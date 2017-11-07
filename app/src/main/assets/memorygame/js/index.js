// Memory Game
// © 2014 Nate Wiley
// License -- MIT
// best in full screen, works on phones/tablets (min height for game is 500px..) enjoy ;)
// Follow me on Codepen

(function(){
	
	var Memory = {

		init: function(cards){
			this.$game = $(".game");
			this.$modal = $(".modal");
			this.$overlay = $(".modal-overlay");
			this.$restartButton = $("button.restart");
			this.cardsArray = $.merge(cards, cards);
			this.shuffleCards(this.cardsArray);
			this.setup();
			this.binding();
		},

		shuffleCards: function(cardsArray){
			this.$cards = $(this.shuffle(this.cardsArray));
		},

		setup: function(){
			this.html = this.buildHTML();
			this.$game.html(this.html);
			this.$memoryCards = $(".card");
			this.paused = false;
     	this.guess = null;
		},

		binding: function(){
			this.$memoryCards.on("click", this.cardClicked);
			this.$restartButton.on("click", $.proxy(this.reset, this));
		},
		// kinda messy but hey
		cardClicked: function(){
			var _ = Memory;
			var $card = $(this);
			if(!_.paused && !$card.find(".inside").hasClass("matched") && !$card.find(".inside").hasClass("picked")){
				$card.find(".inside").addClass("picked");
				if(!_.guess){
					_.guess = $(this).attr("data-id");
				} else if(_.guess == $(this).attr("data-id") && !$(this).hasClass("picked")){
					$(".picked").addClass("matched");
					_.guess = null;
				} else {
					_.guess = null;
					_.paused = true;
					setTimeout(function(){
						$(".picked").removeClass("picked");
						Memory.paused = false;
					}, 600);
				}
				if($(".matched").length == $(".card").length){
					_.win();
				}
			}
		},

		win: function(){
			this.paused = true;
			setTimeout(function(){
				Memory.showModal();
				Memory.$game.fadeOut();
			}, 1000);
		},

		showModal: function(){
			this.$overlay.show();
			this.$modal.fadeIn("slow");
		},

		hideModal: function(){
			this.$overlay.hide();
			this.$modal.hide();
		},

		reset: function(){
			this.hideModal();
			this.shuffleCards(this.cardsArray);
			this.setup();
			this.$game.show("slow");
		},

		// Fisher--Yates Algorithm -- https://bost.ocks.org/mike/shuffle/
		shuffle: function(array){
			var counter = array.length, temp, index;
	   	// While there are elements in the array
	   	while (counter > 0) {
        	// Pick a random index
        	index = Math.floor(Math.random() * counter);
        	// Decrease counter by 1
        	counter--;
        	// And swap the last element with it
        	temp = array[counter];
        	array[counter] = array[index];
        	array[index] = temp;
	    	}
	    	return array;
		},

		buildHTML: function(){
			var frag = '';
			this.$cards.each(function(k, v){
				frag += '<div class="card" data-id="'+ v.id +'"><div class="inside">\
				<div class="front"><img src="'+ v.img +'"\
				alt="'+ v.name +'" /></div>\
				<div class="back"><img src="http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-01.png"\
				alt="Codepen" /></div></div>\
				</div>';
			});
			return frag;
		}
	};

	var cards = [
		{
			name: "php",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-02.png",
			id: 1,
		},
		{
			name: "css3",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-03.png",
			id: 2
		},
		{
			name: "html5",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-04.png",
			id: 3
		},
		{
			name: "jquery",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-05.png",
			id: 4
		}, 
		{
			name: "javascript",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-06.png",
			id: 5
		},
		{
			name: "node",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-07.png",
			id: 6
		},
		{
			name: "photoshop",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-08.png",
			id: 7
		},
		{
			name: "python",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-09.png",
			id: 8
		},
		{
			name: "rails",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-10.png",
			id: 9
		},
		{
			name: "sass",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-11.png",
			id: 10
		},
		{
			name: "sublime",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-12.png",
			id: 11
		},
		{
			name: "wordpress",
			img: "http://uniagustiniana.edu.co/images/images-android/Imagenes-juego-13.png",
			id: 12
		},
	];
    
	Memory.init(cards);


})();