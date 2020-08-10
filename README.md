![Apache Cassandra](https://andreyex.ru/wp-content/uploads/2016/12/Kak-ustanovit-Cassandra-na-CentOS-7.png)
![Apache Cassandra](https://miro.medium.com/max/512/1*k73wp-nDid53eeQ0RDGvdw.png)
![Apache Cassandra](https://cdn.iconscout.com/icon/free/png-256/gradle-3-1175026.png)

# Mini Bank

## Используемые версии
* Ubuntu 18.04.4 LTS

* openjdk version "1.8.0_162"
* OpenJDK Runtime Environment (build 1.8.0_162-8u162-b12-1-b12)
* OpenJDK 64-Bit Server VM (build 25.162-b12, mixed mode)

* Apache Cassandra 3.11.7

### При возникновении ошибок

  $ nodetool status
  error: null
  — StackTrace —
  java.lang.NullPointerException

  $ cqlsh
  Connection error: ('Unable to connect to any servers', {'127.0.0.1': error(111, "Tried connecting to [('127.0.0.1', 9042)]. Last error: Connection refused")})

### Измените версию openjdk, которая вызывается по умолчанию на 8-ую

  $ sudo update-alternatives --config java
  Есть 3 варианта для альтернативы java (предоставляет /usr/bin/java).

    Выбор   Путь                                        Приор Состояние
  ------------------------------------------------------------
    0            /usr/lib/jvm/java-11-openjdk-amd64/bin/java      1101      автоматический режим
    1            /usr/lib/jvm/java-11-openjdk-amd64/bin/java      1101      ручной режим
    2            /usr/lib/jvm/java-11-oracle/bin/java             1091      ручной режим
    3            /usr/lib/jvm/java-8-openjdk-amd64/jre/bin/java   1081      ручной режим

  Press <enter> to keep the current choice[*], or type selection number: **введите номер, под которым java8**
  
  $ java --version
  openjdk version "1.8.0_162"
  OpenJDK Runtime Environment (build 1.8.0_162-8u162-b12-1-b12)
  OpenJDK 64-Bit Server VM (build 25.162-b12, mixed mode)

