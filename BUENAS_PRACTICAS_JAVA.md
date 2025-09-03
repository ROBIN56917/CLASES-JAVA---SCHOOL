# Buenas Prácticas de Desarrollo Java

## 1. Convenciones de Código

### Nomenclatura
- **Clases**: `PascalCase` (ej: `MiClase`)
- **Métodos y variables**: `camelCase` (ej: `miMetodo`, `miVariable`)
- **Constantes**: `MAYUSCULAS_CON_GUIÓN_BAJO` (ej: `MAX_INTENTOS`)
- **Paquetes**: solo minúsculas, sin guiones ni caracteres especiales

### Estructura
- Un archivo por clase
- Usar modificadores de acceso adecuados
- Máximo 300-400 líneas por clase
- Máximo 20-30 líneas por método

## 2. Programación con Swing

### Patrón MVC
- Separar Modelo, Vista y Controlador
- Usar `SwingWorker` para operaciones largas
- Implementar interfaces de listener para eventos

### Hilos
- No bloquear el Event Dispatch Thread (EDT)
- Usar `SwingUtilities.invokeLater()` para actualizar UI

### Componentes
- Usar `BorderLayout` como layout principal
- Implementar `ListModel`/`TableModel` para datos dinámicos
- Usar `JPanel` para agrupar componentes

## 3. Spring Boot

### Estructura
```
src/main/java/com/empresa/aplicacion/
├── config/
├── controller/
├── model/
├── repository/
└── service/
```

### Anotaciones Clave
- `@SpringBootApplication`
- `@RestController`/`@Controller`
- `@Service`, `@Repository`, `@Component`
- `@Autowired` (preferir inyección por constructor)

### Configuración
- Usar `application.properties` o `application.yml`
- Perfiles de configuración con `@Profile`
- Propiedades personalizadas con `@ConfigurationProperties`

## 4. Pruebas

### Unitarias (JUnit 5)
```java
@Test
@DisplayName("Prueba de ejemplo")
void ejemploPrueba() {
    // Arrange
    
    // Act
    
    // Assert
    assertTrue(condicion);
}
```

### Integración
```java
@SpringBootTest
@AutoConfigureMockMvc
class ControladorPruebaIntegracion {
    @Autowired
    private MockMvc mockMvc;
    
    @Test
    void testEndpoint() throws Exception {
        mockMvc.perform(get("/api/ejemplo"))
               .andExpect(status().isOk());
    }
}
```

## 5. Manejo de Errores

### Controlador de Excepciones
```java
@ControllerAdvice
public class ManejadorGlobalExcepciones {
    @ExceptionHandler(RecursoNoEncontradoException.class)
    public ResponseEntity<ErrorResponse> manejarRecursoNoEncontrado(
            RecursoNoEncontradoException ex) {
        return new ResponseEntity<>(
            new ErrorResponse(ex.getMessage()),
            HttpStatus.NOT_FOUND
        );
    }
}
```

## 6. Seguridad

### Spring Security
```java
@Configuration
@EnableWebSecurity
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/publico/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
            .logout()
                .permitAll();
    }
}
```

## 7. Documentación

### JavaDoc
```java
/**
 * Realiza una operación importante.
 *
 * @param parametro Descripción del parámetro
 * @return Descripción del valor de retorno
 * @throws MiExcepcion Cuando ocurre un error específico
 */
public String miMetodo(String parametro) throws MiExcepcion {
    // Implementación
}
```

### API REST (OpenAPI/Swagger)
```java
@OpenAPIDefinition(
    info = @Info(
        title = "API de Ejemplo",
        version = "1.0",
        description = "Documentación de la API"
    )
)
public class ConfiguracionSwagger {
    @Bean
    public OpenAPI api() {
        return new OpenAPI()
            .components(new Components())
            .info(new Info()
                .title("API de Ejemplo")
                .version("1.0")
            );
    }
}
```

## 8. Patrones de Diseño

### Singleton
```java
public class MiSingleton {
    private static MiSingleton instancia;
    
    private MiSingleton() {}
    
    public static synchronized MiSingleton getInstancia() {
        if (instancia == null) {
            instancia = new MiSingleton();
        }
        return instancia;
    }
}
```

### Factory
```java
public interface Figura {
    void dibujar();
}

public class FabricaFiguras {
    public static Figura crearFigura(String tipo) {
        return switch (tipo.toLowerCase()) {
            case "circulo" -> new Circulo();
            case "cuadrado" -> new Cuadrado();
            default -> throw new IllegalArgumentException("Tipo de figura no soportado");
        };
    }
}
```

## 9. Optimización de Rendimiento

### Colecciones
- Usar `ArrayList` para acceso aleatorio frecuente
- Usar `LinkedList` para inserciones/eliminaciones frecuentes
- Usar `HashSet` para conjuntos sin orden
- Usar `TreeSet` para conjuntos ordenados

### Cadenas
- Usar `StringBuilder` para concatenación en bucles
- Usar `String.format()` para cadenas complejas

## 10. Control de Versiones

### Convención de Commits
```
tipo(ámbito): descripción breve

Cuerpo más detallado si es necesario

[#ticket]  # Opcional: referencia a ticket
```

### Tipos de Commit
- `feat`: Nueva característica
- `fix`: Corrección de error
- `docs`: Cambios en documentación
- `style`: Formato, punto y coma faltante, etc.
- `refactor`: Cambios que no corrigen errores ni agregan funcionalidad
- `test`: Agregar o modificar pruebas
- `chore`: Actualización de tareas de compilación, configuraciones, etc.

## 11. Herramientas Recomendadas

### Desarrollo
- **IDE**: IntelliJ IDEA, Eclipse, VS Code
- **Build**: Maven, Gradle
- **Control de Versiones**: Git

### Calidad de Código
- **Análisis Estático**: SonarQube, Checkstyle, PMD
- **Formato**: Google Java Format, Spotless
- **Cobertura**: JaCoCo, Cobertura

### CI/CD
- **Integración Continua**: Jenkins, GitHub Actions, GitLab CI
- **Despliegue**: Docker, Kubernetes
