# QvantelRecruitmentTracking

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
<li>Install the MYSql database schema from <home>/sql/MYSQL_script.sql .
<li>From eclipse run the project as 'Maven clean install'.
<li>Configure database connection pooling in <code>Tocat server</code> by adding the following code in <br/>
  <i>Tomcat_home/server.xml</i> <br/>
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
  username="root"/></textarea>
</ol>
