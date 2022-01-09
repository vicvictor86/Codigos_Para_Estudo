const booksByCategory = [
    {
        category: "Riqueza",
        books: [
            {
                title: "Os segredos da mente milionária",
                author: "T. Harv Eker",
            },
            {
                title: "O homem mais rico da Babilônia",
                author: "George S. Clason",
            },
            {
                title: "Pai rico, pai pobre",
                author: "Robert T. Kiyosaki , Sharon L. Lechter",
            },
        ],
    },
    {
        category: "Inteligência Emocional",
        books: [
            {
                title: "Você é Insubstituível",
                author: "Augusto Cury",
            },
            {
                title: "Ansiedade – Como enfrentar o mal do século",
                author: "Augusto Cury",
            },
            {
                title: "Os 7 hábitos das pessoas altamente eficazes",
                author: "Stephen R. Covey",
            },
        ],
    },
];

function countCategory(){
    for(let category of booksByCategory){
        console.log('Total de livros da categoria: ', category.category);
        console.log(category.books.length);
    }
}

function countBooks(){
    let totalBooks = 0;
    for(let category of booksByCategory){
        totalBooks += category.books.length
    }
    console.log('Total de livros: ', totalBooks);
}

function countAuthor(){
    let authorsList = [];
    for(category of booksByCategory){
        for(book of category.books){
            let author = book.author;
            if(author.includes(",")){
                let authors = author.split(",");
                for(let authorActual of authors){
                    if(!authorsList.includes(authorActual)){
                        authorsList.push(authorActual)
                    }
                }
            }else if(!authorsList.includes(author)){
                authorsList.push(author)
            }
        }
    }
    console.log('Total de autores: ', authorsList.length);
}

function ShowAuthor(authorName){
    let bookList = [];
    for(category of booksByCategory){
        for(book of category.books){
            let author = book.author;
            if(author == authorName){
                bookList.push(book.title);
            }
        }
    }
    console.log('Livros do autor: ', authorName, bookList.join(", "));
}

countCategory();
countBooks();
countAuthor();
ShowAuthor("Augusto Cury");