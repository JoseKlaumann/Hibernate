# Hibernate
- Alteracoes que devem ser alteradas no arquivo .xml: 
1. name;
2. Qual o banco utilizado, numero da porta, e nome da tabela
  <property name="hibernate.connection.url" value="jdbc:MySql://localhost:3306/coursejdbc"/>
  Nome do usuario
  <property name="hibernate.connection.user" value="root"/>
  <!-- Colocar a senha utilizada -->
  <property name="hibernate.connection.password" value="  "/>
  Caminho para o hibernate encontra o drive do banco que sera utilizado
  <property name="hibernate.connection.driver_class" value="com.mysql.jdbc.Driver"/>
