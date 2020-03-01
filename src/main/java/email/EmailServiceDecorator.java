package email;

import employee.Employee;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class EmailServiceDecorator implements EmailService {

    private EmailService emailService;

    public EmailServiceDecorator(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public boolean send(Employee from, List<Employee> recipient, String title, String content) throws FileNotFoundException {

        PrintWriter save = new PrintWriter("mail.txt");
        emailService.send(from, recipient,title,content);
        save.println(content);
        save.close();
        return true;
    }
}
