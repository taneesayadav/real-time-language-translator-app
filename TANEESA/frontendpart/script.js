// Add event listeners for language dropdown changes
document.getElementById('sourceLang').addEventListener('change', translateText);
document.getElementById('targetLang').addEventListener('change', translateText);

// Translate text as user types or changes language
function translateText() {
    const inputText = document.getElementById('inputText').value;
    const sourceLang = document.getElementById('sourceLang').value;
    const targetLang = document.getElementById('targetLang').value;

    if (!inputText.trim()) {
        document.getElementById('outputText').value = '';
        return;
    }

    // Simulate translation process
    setTimeout(() => {
        const translatedText = simulateTranslation(inputText, sourceLang, targetLang);
        document.getElementById('outputText').value = translatedText;
    }, 500);
}

// Simulated translation logic
function simulateTranslation(text, source, target) {
    const fakeTranslations = {
        "en": {
            "fr": "Traduit en français: " + text,
            "es": "Traducido al español: " + text,
            "de": "Übersetzt ins Deutsche: " + text
        },
        "fr": {
            "en": "Translated to English: " + text,
            "es": "Traducido al español: " + text,
            "de": "Übersetzt ins Deutsche: " + text
        },
        "es": {
            "en": "Translated to English: " + text,
            "fr": "Traduit en français: " + text,
            "de": "Übersetzt ins Deutsche: " + text
        },
        "de": {
            "en": "Translated to English: " + text,
            "fr": "Traduit en français: " + text,
            "es": "Traducido al español: " + text
        }
    };

    return fakeTranslations[source] && fakeTranslations[source][target] 
        ? fakeTranslations[source][target] 
        : "Translation not available.";
}
