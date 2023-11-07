package com.keyboard.blindboard

import co.thingthing.fleksy.core.feedback.ResourceSoundSet
import co.thingthing.fleksy.core.feedback.SoundMode
import co.thingthing.fleksy.core.feedback.VibrationMode
import co.thingthing.fleksy.core.feedback.VibrationMode.Haptic
import co.thingthing.fleksy.core.keyboard.Icon
import co.thingthing.fleksy.core.keyboard.KeyboardConfiguration
import co.thingthing.fleksy.core.keyboard.KeyboardService
import co.thingthing.fleksy.core.prediction.model.PredictionModelType

class SecondKeyboard : KeyboardService() {

    override fun createConfiguration(): KeyboardConfiguration {
        return KeyboardConfiguration(
            license = KeyboardConfiguration.LicenseConfiguration(
                licenseKey = "fd9955f9-f3c2-45e6-a212-9f20e9600849",
                licenseSecret = "a54517ce144bfa555d7b49f59547f80c"
            ),
            feedback = KeyboardConfiguration.FeedbackConfiguration(
            vibrationMode = VibrationMode.Haptic(true,200),

            ),
            typing = KeyboardConfiguration.TypingConfiguration(
                autoCorrect = true,
                allowBackspaceToUndoAC = true,
                caseSensitive = true,
                smartPunctuation = true,
                tripleSpaceAddsSpaceKey = true,

                magicButtonIcon = Icon.COMMA,
                holdMode = KeyboardConfiguration.HoldMode.POP,
                swipeTyping = true
            ),
            features=KeyboardConfiguration.FeaturesConfiguration(
                emojiPrediction = true,
                textToSpeech = true,
                suggestionGestures = true

            ),
            emoji = KeyboardConfiguration.EmojiConfiguration(
                keepVariations = true,
                recent = DEFAULT_RECENT_EMOJI,
                defaultSkinTone = KeyboardConfiguration.EmojiSkinTone.NEUTRAL,
                defaultGender = KeyboardConfiguration.EmojiGender.NEUTRAL,
                androidOnly = true
            ),
            predictions = KeyboardConfiguration.PredictionsConfiguration(
                predictionTypes = listOf(PredictionModelType.WORD, PredictionModelType.EMOJI),
                showEmojiSuggestions = true,
                showEnteredText = true
            ),
        )
    }
    companion object {


        private val DEFAULT_RECENT_EMOJI = setOf(
            "😂", "😍", "😭", "☺️", "😘", "👏", "🙏", "👌", "👍",
            "🙌", "❤️", "💕", "💓", "💙", "💗", "✨", "🔥", "🎉",
            "💯", "🙈", "🎂", "🍕", "🍓", "🍻", "☕"
        )
    }
}