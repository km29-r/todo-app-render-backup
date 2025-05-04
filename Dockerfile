# Java 17 の公式イメージを使う
FROM eclipse-temurin:17-jdk

# 作業ディレクトリを設定
WORKDIR /app

# Maven Wrapper 関連ファイルを先にコピー
COPY .mvn /app/.mvn
COPY mvnw /app
COPY pom.xml /app

# ソースコードを後でコピー（キャッシュの活用）
COPY src /app/src

# 実行権限を付与
RUN chmod +x mvnw

# ビルド（テストはスキップ）
RUN ./mvnw clean package -DskipTests

# target に生成されたJARを app.jar という名前で移動
RUN cp target/*.jar app.jar

# ポート開放
EXPOSE 8080

# アプリ起動
CMD ["java", "-jar", "app.jar"]
