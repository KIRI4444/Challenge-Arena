# Указываем базовый образ
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем JAR файл в контейнер
COPY target/Challenge-Arena-0.0.1-SNAPSHOT.jar application.jar

# Устанавливаем метаданные
LABEL maintainer="Challenge-Arena" \
      version="1.0" \
      description="Java Sprinng Boot app"

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "application.jar"]
