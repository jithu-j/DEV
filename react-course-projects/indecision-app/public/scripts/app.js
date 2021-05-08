'use strict';

console.log('App.js is working!');

//JSX - Javascript XML

function getSubtitle(sb) {
    if (sb) {
        return React.createElement(
            'p',
            null,
            main.subtitle
        );
    }
}

var main = {
    title: 'Indecision App',
    subtitle: 'First para',
    options: ['one', 'two']
};

var template = React.createElement(
    'div',
    null,
    React.createElement(
        'h1',
        null,
        main.title && main.title
    ),
    getSubtitle(main.subtitle),
    main.options.length > 0 ? 'Available options' : 'No Options',
    React.createElement(
        'ol',
        null,
        React.createElement(
            'li',
            null,
            'Mango'
        ),
        React.createElement(
            'li',
            null,
            'Orange'
        )
    )
);

var templateTwo = React.createElement(
    'div',
    null,
    React.createElement(
        'h1',
        null,
        'Jithu'
    ),
    React.createElement(
        'p',
        null,
        'Age:24'
    ),
    React.createElement(
        'p',
        null,
        'Location:India'
    )
);

var appRoot = document.getElementById('app');

ReactDOM.render(template, appRoot);
//ReactDOM.render(templateTwo,appRoot);
