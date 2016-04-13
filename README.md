# Qvantel Recruitment Tracking

<strong><h3>Installation</h3></strong>

<strong>Required Softwares</strong>
<ul>
<li>Java 7
<li>Eclipse with Maven
<li>Tomcat 7
<li>MYSql Database
</ul>

<strong>Steps to install</strong>
<ol>
<li>Clone the <code>QvantelRecruitmentTracking</code> project in to the local machine.
<li>Import the project in to eclipse as existing maven project.
<li>Install the application's MYSql database schema from <home>/sql/MYSQL_script.sql .
<li>From eclipse run the project as <code>Maven</code> 'clean install'.
<li>Configure database connection pooling in <code>Tocat server</code> <i>(according to your machine parameters)</i> by adding the following code in <br/>
  <code><i>Tomcat_home/server.xml</i></code> <br/>
  <textarea><Resource auth="Container" 
  driverClassName="com.mysql.jdbc.Driver" 
  global="jdbc/Qvantel_DB" 
  maxActive="100" 
  maxIdle="20" 
  maxWait="10000" 
  minIdle="5" 
  name="jdbc/Qvantel_DB" 
  password="qvantel" 
  type="javax.sql.DataSource" 
  url="jdbc:mysql://localhost:3306/qvantel_recruitment_tracking" 
  username="root"/></textarea><br/>
  <code><i>Tomacat_home/context.xml</i></code> </br>
  <textarea><ResourceLink name="jdbc/Qvantel_DB" global="jdbc/Qvantel_DB"
	auth="Container" type="javax.sql.DataSource" /></textarea>
<li>Add <code>servlet-api.jar</code> to the <code>Tomcat server</code> lib directory.
</ol>
