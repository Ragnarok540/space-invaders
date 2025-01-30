# space-invaders

| Pattern        | Functionality  |
| -------------- | -------------- |
| Null Object    | Player         |
| Memento        | Player         |
| Proxy          | Player         |
| Prototype      | Bullets        |
| Factory Method | Enemies        |
| Facade         | Model          |
| Singleton      | Player Ship    |
| Flyweight      | Sprites        |
| Command        | Keyboard Input |



mvn checkstyle:check

mvn package

java -cp target/space-invaders-1.0-SNAPSHOT.jar edu.patterns.gui.Game

mvn javadoc:javadoc
