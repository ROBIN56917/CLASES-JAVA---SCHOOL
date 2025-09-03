class School:
    """
    A class representing a school with courses, students, teachers, and subjects.
    Follows Model Context Protocol (MCP) naming conventions.
    """
    
    def __init__(self, course: str, student: str, teacher: str, subject: str):
        """
        Initialize a new School instance.
        
        Args:
            course (str): The course or grade level
            student (str): Student's full name
            teacher (str): Teacher's full name
            subject (str): Name of the subject being taught
        """
        self.course = course
        self.student = student
        self.teacher = teacher
        self.subject = subject
    
    def __str__(self) -> str:
        """Return a string representation of the School instance."""
        return (
            f"School(course='{self.course}', student='{self.student}', "
            f"teacher='{self.teacher}', subject='{self.subject}')"
        )

# Example usage
if __name__ == "__main__":
    # Create a school instance
    school = School(
        course="10th Grade",
        student="John Doe",
        teacher="Jane Smith",
        subject="Mathematics"
    )
    
    # Print the school information
    print(school)
