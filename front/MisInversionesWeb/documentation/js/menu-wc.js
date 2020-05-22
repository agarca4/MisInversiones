'use strict';


customElements.define('compodoc-menu', class extends HTMLElement {
    constructor() {
        super();
        this.isNormalMode = this.getAttribute('mode') === 'normal';
    }

    connectedCallback() {
        this.render(this.isNormalMode);
    }

    render(isNormalMode) {
        let tp = lithtml.html(`
        <nav>
            <ul class="list">
                <li class="title">
                    <a href="index.html" data-type="index-link">mis-inversiones-web documentation</a>
                </li>

                <li class="divider"></li>
                ${ isNormalMode ? `<div id="book-search-input" role="search"><input type="text" placeholder="Type to search"></div>` : '' }
                <li class="chapter">
                    <a data-type="chapter-link" href="index.html"><span class="icon ion-ios-home"></span>Getting started</a>
                    <ul class="links">
                        <li class="link">
                            <a href="overview.html" data-type="chapter-link">
                                <span class="icon ion-ios-keypad"></span>Overview
                            </a>
                        </li>
                        <li class="link">
                            <a href="index.html" data-type="chapter-link">
                                <span class="icon ion-ios-paper"></span>README
                            </a>
                        </li>
                                <li class="link">
                                    <a href="dependencies.html" data-type="chapter-link">
                                        <span class="icon ion-ios-list"></span>Dependencies
                                    </a>
                                </li>
                    </ul>
                </li>
                    <li class="chapter modules">
                        <a data-type="chapter-link" href="modules.html">
                            <div class="menu-toggler linked" data-toggle="collapse" ${ isNormalMode ?
                                'data-target="#modules-links"' : 'data-target="#xs-modules-links"' }>
                                <span class="icon ion-ios-archive"></span>
                                <span class="link-name">Modules</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                        </a>
                        <ul class="links collapse " ${ isNormalMode ? 'id="modules-links"' : 'id="xs-modules-links"' }>
                            <li class="link">
                                <a href="modules/AppModule.html" data-type="entity-link">AppModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-AppModule-8f3dd7b9c05d1f667b8374d88aac1e95"' : 'data-target="#xs-components-links-module-AppModule-8f3dd7b9c05d1f667b8374d88aac1e95"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-AppModule-8f3dd7b9c05d1f667b8374d88aac1e95"' :
                                            'id="xs-components-links-module-AppModule-8f3dd7b9c05d1f667b8374d88aac1e95"' }>
                                            <li class="link">
                                                <a href="components/AppComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">AppComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/CarterasModule.html" data-type="entity-link">CarterasModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-CarterasModule-f736cf0bc0a4ebac797eeac35ff4c494"' : 'data-target="#xs-components-links-module-CarterasModule-f736cf0bc0a4ebac797eeac35ff4c494"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-CarterasModule-f736cf0bc0a4ebac797eeac35ff4c494"' :
                                            'id="xs-components-links-module-CarterasModule-f736cf0bc0a4ebac797eeac35ff4c494"' }>
                                            <li class="link">
                                                <a href="components/CarterasDetalleComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">CarterasDetalleComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/CarterasFormComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">CarterasFormComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/CarterasHomeComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">CarterasHomeComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/CarterasListaComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">CarterasListaComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/CarterasMenuComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">CarterasMenuComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ComponentesReusablesModule.html" data-type="entity-link">ComponentesReusablesModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ComponentesReusablesModule-4e1b151e01f9bd610c1c98e12fe043ea"' : 'data-target="#xs-components-links-module-ComponentesReusablesModule-4e1b151e01f9bd610c1c98e12fe043ea"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ComponentesReusablesModule-4e1b151e01f9bd610c1c98e12fe043ea"' :
                                            'id="xs-components-links-module-ComponentesReusablesModule-4e1b151e01f9bd610c1c98e12fe043ea"' }>
                                            <li class="link">
                                                <a href="components/FavoritoComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">FavoritoComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ComunModule.html" data-type="entity-link">ComunModule</a>
                                    <li class="chapter inner">
                                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ?
                                            'data-target="#components-links-module-ComunModule-e30c597cafed203bed1bc5f78338a850"' : 'data-target="#xs-components-links-module-ComunModule-e30c597cafed203bed1bc5f78338a850"' }>
                                            <span class="icon ion-md-cog"></span>
                                            <span>Components</span>
                                            <span class="icon ion-ios-arrow-down"></span>
                                        </div>
                                        <ul class="links collapse" ${ isNormalMode ? 'id="components-links-module-ComunModule-e30c597cafed203bed1bc5f78338a850"' :
                                            'id="xs-components-links-module-ComunModule-e30c597cafed203bed1bc5f78338a850"' }>
                                            <li class="link">
                                                <a href="components/CabeceraComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">CabeceraComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/HomeComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">HomeComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/NoDisponibleComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">NoDisponibleComponent</a>
                                            </li>
                                            <li class="link">
                                                <a href="components/PieComponent.html"
                                                    data-type="entity-link" data-context="sub-entity" data-context-id="modules">PieComponent</a>
                                            </li>
                                        </ul>
                                    </li>
                            </li>
                            <li class="link">
                                <a href="modules/ServiciosModule.html" data-type="entity-link">ServiciosModule</a>
                            </li>
                </ul>
                </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#classes-links"' :
                            'data-target="#xs-classes-links"' }>
                            <span class="icon ion-ios-paper"></span>
                            <span>Classes</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="classes-links"' : 'id="xs-classes-links"' }>
                            <li class="link">
                                <a href="classes/AppPage.html" data-type="entity-link">AppPage</a>
                            </li>
                            <li class="link">
                                <a href="classes/CarterasService.html" data-type="entity-link">CarterasService</a>
                            </li>
                            <li class="link">
                                <a href="classes/ManejadorError.html" data-type="entity-link">ManejadorError</a>
                            </li>
                        </ul>
                    </li>
                        <li class="chapter">
                            <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#injectables-links"' :
                                'data-target="#xs-injectables-links"' }>
                                <span class="icon ion-md-arrow-round-down"></span>
                                <span>Injectables</span>
                                <span class="icon ion-ios-arrow-down"></span>
                            </div>
                            <ul class="links collapse " ${ isNormalMode ? 'id="injectables-links"' : 'id="xs-injectables-links"' }>
                                <li class="link">
                                    <a href="injectables/CarterasApiService.html" data-type="entity-link">CarterasApiService</a>
                                </li>
                            </ul>
                        </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#interfaces-links"' :
                            'data-target="#xs-interfaces-links"' }>
                            <span class="icon ion-md-information-circle-outline"></span>
                            <span>Interfaces</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? ' id="interfaces-links"' : 'id="xs-interfaces-links"' }>
                            <li class="link">
                                <a href="interfaces/Cartera.html" data-type="entity-link">Cartera</a>
                            </li>
                            <li class="link">
                                <a href="interfaces/FavoritoEvent.html" data-type="entity-link">FavoritoEvent</a>
                            </li>
                        </ul>
                    </li>
                    <li class="chapter">
                        <div class="simple menu-toggler" data-toggle="collapse" ${ isNormalMode ? 'data-target="#miscellaneous-links"'
                            : 'data-target="#xs-miscellaneous-links"' }>
                            <span class="icon ion-ios-cube"></span>
                            <span>Miscellaneous</span>
                            <span class="icon ion-ios-arrow-down"></span>
                        </div>
                        <ul class="links collapse " ${ isNormalMode ? 'id="miscellaneous-links"' : 'id="xs-miscellaneous-links"' }>
                            <li class="link">
                                <a href="miscellaneous/variables.html" data-type="entity-link">Variables</a>
                            </li>
                        </ul>
                    </li>
                    <li class="chapter">
                        <a data-type="chapter-link" href="coverage.html"><span class="icon ion-ios-stats"></span>Documentation coverage</a>
                    </li>
                    <li class="divider"></li>
                    <li class="copyright">
                        Documentation generated using <a href="https://compodoc.app/" target="_blank">
                            <img data-src="images/compodoc-vectorise.png" class="img-responsive" data-type="compodoc-logo">
                        </a>
                    </li>
            </ul>
        </nav>
        `);
        this.innerHTML = tp.strings;
    }
});