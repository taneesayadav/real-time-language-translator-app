package com.languagetranslator.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class languagetranslatorDAO {

    // Database connection properties
    private String jdbcURL = "jdbc:mysql://localhost:3306/translatorappdb";  // Update DB details
    private String jdbcUserName = "root";
    private String jdbcPassword = "root";

    // SQL Queries
    private static final String INSERT_TRANSLATION_SQL = "INSERT INTO translations (original_text, translated_text, source_lang, target_lang) VALUES (?, ?, ?, ?);";
    private static final String SELECT_TRANSLATION_BY_ID = "SELECT * FROM translations WHERE id = ?;";
    private static final String SELECT_ALL_TRANSLATIONS = "SELECT * FROM translations;";
    private static final String DELETE_TRANSLATION_SQL = "DELETE FROM translations WHERE id = ?;";
    private static final String UPDATE_TRANSLATION_SQL = "UPDATE translations SET original_text = ?, translated_text = ?, source_lang = ?, target_lang = ? WHERE id = ?;";

    // Method to get the database connection
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Insert a new translation
    public void insertTranslation(Translation translation) throws SQLException {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TRANSLATION_SQL);
            preparedStatement.setString(1, translation.getOriginalText());
            preparedStatement.setString(2, translation.getTranslatedText());
            preparedStatement.setString(3, translation.getSourceLang());
            preparedStatement.setString(4, translation.getTargetLang());

            preparedStatement.executeUpdate();
        }
    }

    // Select a translation by ID
    public Translation selectTranslation(int id) {
        Translation translation = null;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_TRANSLATION_BY_ID);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String originalText = resultSet.getString("original_text");
                String translatedText = resultSet.getString("translated_text");
                String sourceLang = resultSet.getString("source_lang");
                String targetLang = resultSet.getString("target_lang");

                Translation(id, originalText, translatedText, sourceLang, targetLang);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return translation;
    }

    private com.languagetranslator.dao.Translation Translation(int id, String originalText, String translatedText, String sourceLang, String targetLang) {
		return null;
		// TODO Auto-generated method stub
		
	}

	// Select all translations
    public List<Translation> selectAllTranslations() {
        List<Translation> translations = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_TRANSLATIONS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String originalText = resultSet.getString("original_text");
                String translatedText = resultSet.getString("translated_text");
                String sourceLang = resultSet.getString("source_lang");
                String targetLang = resultSet.getString("target_lang");

                translations.add( Translation(id, originalText, translatedText, sourceLang, targetLang));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return translations;
    }

    // Delete a translation by ID
    public boolean deleteTranslation(int id) throws SQLException {
        boolean rowDeleted = false;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_TRANSLATION_SQL);
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    // Update an existing translation
    public boolean updateTranslation(Translation translation) throws SQLException {
        boolean rowUpdated = false;
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_TRANSLATION_SQL);
            preparedStatement.setString(1, translation.getOriginalText());
            preparedStatement.setString(2, translation.getTranslatedText());
            preparedStatement.setString(3, translation.getSourceLang());
            preparedStatement.setString(4, translation.getTargetLang());
            preparedStatement.setInt(5, translation.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
