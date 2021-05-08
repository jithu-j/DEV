console.log('App.js is working!');

//JSX - Javascript XML

function getSubtitle (sb) {
    if (sb) {
        return <p>{main.subtitle}</p>;
    }
}

var main = {
    title: 'Indecision App',
    subtitle: 'First para',
    options: ['one','two']
};

var template = (
    <div>
        <h1>{main.title && main.title}</h1>
        {getSubtitle(main.subtitle)}
        {main.options.length>0 ? 'Available options' : 'No Options'}
        <ol>
            <li>Mango</li>
            <li>Orange</li>
        </ol>
    </div>
);

var templateTwo = (
    <div>
        <h1>Jithu</h1>
        <p>Age:24</p>
        <p>Location:India</p>
    </div>
);

var appRoot = document.getElementById('app');

ReactDOM.render(template,appRoot);
//ReactDOM.render(templateTwo,appRoot);