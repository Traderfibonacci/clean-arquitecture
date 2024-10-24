package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("123456789-99", "Lucas", LocalDate.parse("1992-06-25"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("12345678999", "Lucas", LocalDate.parse("1992-06-25"), "email@email.com"));

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("", "Lucas", LocalDate.parse("1992-06-25"), "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Lucas", "123.456.789-00",
                LocalDate.parse("2000-10-01"));

        Assertions.assertEquals("Lucas",usuario.getNome());

        usuario = fabrica.incluiEndereco("09599-999",40,"apto 32");

        Assertions.assertEquals("apto 32", usuario.getEndereco().getComplemento());
    }
}