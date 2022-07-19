package br.com.vemser.pessoaapi.service;


import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    //=================================== E-MAIL PESSOA CRIADA ===================================

    public void sendEmailPessoaCriada(PessoaCreateDTO pessoaDTO, Pessoa pessoaCriada) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject(pessoaDTO.getNome() + ", estamos felizes que você chegou!");
            mimeMessageHelper.setText(buscarConteudoPessoaCriada(pessoaDTO, pessoaCriada), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }


    // MÉTODO QUE BUSCA NO DTO OS DADOS QUE SERÃO INSERIDOS NO TEMPLATE DO EMAIL
    public String buscarConteudoPessoaCriada(PessoaCreateDTO pessoaDTO, Pessoa pessoaCriada)
            throws IOException, TemplateException {

        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", "Olá, " + pessoaDTO.getNome() + "! Estamos felizes em ter você em nosso sistema!");
        dados.put("mensagem", "Seu cadastro foi realizado com sucesso, seu identificador é "
                + pessoaCriada.getIdPessoa() + ". Seja bem vindo(a)!");
        dados.put("email", "Qualquer dúvida, nos contate através do e-mail " + from);

        Template template = fmConfiguration.getTemplate("email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }



    //=================================== E-MAIL PESSOA ALTERADA ===================================

    public void sendEmailPessoaAlterada(PessoaCreateDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject(pessoaDTO.getNome() + ", parece que seus dados mudaram...");
            mimeMessageHelper.setText(buscarConteudoPessoaAlterada(pessoaDTO), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    // MÉTODO QUE BUSCA NO DTO OS DADOS QUE SERÃO INSERIDOS NO TEMPLATE DO EMAIL
    public String buscarConteudoPessoaAlterada(PessoaCreateDTO pessoaDTO) throws IOException, TemplateException {

        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", "Olá, " + pessoaDTO.getNome());
        dados.put("mensagem", "Seus dados foram atualizados com sucesso! ");
        dados.put("email", "Qualquer dúvida, nos contate através do e-mail " + from);

        Template template = fmConfiguration.getTemplate("email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    //=================================== E-MAIL PESSOA DELETADA ===================================

    public void sendEmailPessoaDeletada(Pessoa pessoa) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject(pessoa.getNome() +  ", você está nos deixando?");
            mimeMessageHelper.setText(buscarConteudoPessoaDeletada(pessoa), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    // MÉTODO QUE BUSCA NO DTO OS DADOS QUE SERÃO INSERIDOS NO TEMPLATE DO EMAIL
    public String buscarConteudoPessoaDeletada(Pessoa pessoa) throws IOException, TemplateException {

        Map<String, Object> dados = new HashMap<>();

        dados.put("nome", pessoa.getNome() + ", que pena que você está indo embora...");
        dados.put("mensagem", "Seu cadastro foi excluído com sucesso, mas você pode voltar quando quiser! ");
        dados.put("email", "Qualquer dúvida, nos contate através do e-mail " + from);

        Template template = fmConfiguration.getTemplate("email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    //=================================== E-MAIL ENDEREÇO CRIADO ===================================

    public void sendEmailEnderecoCriado(EnderecoCreateDTO enderecoDTO, Pessoa pessoa) {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject(pessoa.getNome() +  ", um novo endereço foi cadastrado!");
            mimeMessageHelper.setText(buscarConteudoEnderecoCriado(enderecoDTO, pessoa), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    // MÉTODO QUE BUSCA NO DTO OS DADOS QUE SERÃO INSERIDOS NO TEMPLATE DO EMAIL
    public String buscarConteudoEnderecoCriado(EnderecoCreateDTO enderecoDTO, Pessoa pessoa)
            throws IOException, TemplateException {

        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Olá, " + pessoa.getNome());
        dados.put("mensagem", "Um novo endereço " + enderecoDTO.getTipo() + " foi cadastrado em seu nome com sucesso!");
        dados.put("email", "Qualquer dúvida, nos contate através do e-mail " + from);

        Template template = fmConfiguration.getTemplate("email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    //=================================== E-MAIL ENDEREÇO ALTERADO ===================================

    public void sendEmailEnderecoAlterado(EnderecoCreateDTO enderecoDTO, Pessoa pessoa) {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject(pessoa.getNome() +  ", seu endereço foi alterado!");
            mimeMessageHelper.setText(buscarConteudoEnderecoAlterado(enderecoDTO, pessoa), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    // MÉTODO QUE BUSCA NO DTO OS DADOS QUE SERÃO INSERIDOS NO TEMPLATE DO EMAIL
    public String buscarConteudoEnderecoAlterado(EnderecoCreateDTO enderecoDTO, Pessoa pessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Olá, " + pessoa.getNome());
        dados.put("mensagem", "Seu endereço " + enderecoDTO.getTipo() + " foi alterado com sucesso!");
        dados.put("email", "Qualquer dúvida, nos contate através do e-mail " + from);

        Template template = fmConfiguration.getTemplate("email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    //=================================== E-MAIL ENDEREÇO DELETADO ===================================

    public void sendEmailEnderecoDeletado(Endereco endereco, Pessoa pessoa) {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject(pessoa.getNome() +  ", seu endereço foi excluído!");
            mimeMessageHelper.setText(buscarConteudoEnderecoDeletado(endereco, pessoa), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    // MÉTODO QUE BUSCA NO DTO OS DADOS QUE SERÃO INSERIDOS NO TEMPLATE DO EMAIL
    public String buscarConteudoEnderecoDeletado(Endereco endereco, Pessoa pessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Olá, " + pessoa.getNome());
        dados.put("mensagem", "Seu endereço " + endereco.getTipo() + " foi excluído com sucesso!");
        dados.put("email", "Qualquer dúvida, nos contate através do e-mail " + from);

        Template template = fmConfiguration.getTemplate("email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }


    /*
    //================ ENVIA E-MAIL SIMPLES ================

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("patricia.neimaier@dbccompany.com.br");
        message.setSubject("Assunto 1");
        message.setText("Meu e-mail!");
        emailSender.send(message);
    }


    //================ ENVIA E-MAIL COM ANEXO ================

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo("patricia.neimaier@dbccompany.com.br");
        helper.setSubject("Assunto 1");
        helper.setText("Meu e-mail!");

        // Forma 1
//        File file1 = new File("imagem.jpg");
//        FileSystemResource file
//                = new FileSystemResource(file1);
//        helper.addAttachment(file1.getName(), file);


        // Forma 2
        ClassLoader classLoader = getClass().getClassLoader();
        File file2 = new File(classLoader.getResource("caramelo.jpg").getFile());
        FileSystemResource file = new FileSystemResource(file2);
        helper.addAttachment(file2.getName(), file);

//        System.out.println("F: " + file2.getPath());
        // src/main/resources/imagem.jpg

        emailSender.send(message);
    }



    //================ ENVIA E-MAIL COM TEMPLATE================
    public void sendEmail() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(from);
            mimeMessageHelper.setSubject("Assunto 3");
            mimeMessageHelper.setText(geContentFromTemplate(), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }

    }

        // MÉTODO para inserir nos campos de dados do template
    public String geContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Patrícia");
        dados.put("email", "aaa@aaa");

        Template template = fmConfiguration.getTemplate("email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
    */

    // ============================================================================================================
/*
    // MÉTODO QUE BUSCA NO DTO OS DADOS QUE SERÃO INSERIDOS NO TEMPLATE DO EMAIL
    public String buscarConteudoPessoaCriada(PessoaCreateDTO pessoaDTO, PessoaDTO pessoaD) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Olá, " + pessoaDTO.getNome() + "! Estamos felizes em ter você em nosso sistema!");
        dados.put("mensagem", "Seu cadastro foi realizado com sucesso, seu identificador é " + pessoaDTO.getIdPessoa()
                + ". Seja bem vindo(a)!");
        dados.put("email", "Qualquer dúvida, nos contate através do e-mail " + from);

        Template template = fmConfiguration.getTemplate("email-template.html");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
    */

}