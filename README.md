# WAR
War card game

This was a class project that basically creates two "players" to play the war card game.
When the app is started, the user is prompted to choose from various menu options like creating
a new deck, shuffling deck, showing deck, playing war, and exiting. A card has suit and rank attributes. 
A deck object is made up of 52 card objects. To shuffle a deck, we basically choose 2 random cards
and swap their "places" in the deck or their postition in the arraylist. When playing war, cards are dealt
from each player's deck and whoever has the higher rank takes both cards and places them in their deck.
If the cards have the same rank, 3 cards are taken from player's decks "faced down". Players then show one
more card and whoever has the higher rank takes all cards. This continues until a player runs out of cards.
