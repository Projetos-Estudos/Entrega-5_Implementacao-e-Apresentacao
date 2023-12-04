



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import Junit.junitTests.ProjetoDAOTest;
import Junit.junitTests.ProjetoTest;
import Junit.junitTests.UsuarioDAOTest;
import Junit.junitTests.SessaoUsuarioTest;
import Junit.junitTests.UsuarioTest;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


@Suite
@SelectPackages("junit")
@SelectClasses( {UsuarioDAOTest.class,ProjetoDAOTest.class, SessaoUsuarioTest.class, UsuarioTest.class, ProjetoTest.class})
public class SuiteTest {
    
}