package Kata01.V02;

import Kata01.*;

/**
 * Rechte Maustaste Klick = RMK
 *
 * TODO 1 (Aus Einer langen Frunktion eine Klasse extrahieren)
 *
 *  'Function Body' markieren
 *  RMK => Refactor => Extract => Object Method....
 *  Create Inner Class, Name = 'TestableHtmlMaker'
 *  Visibility: Private
 *  Parameters:
 *    PageData pageData
 *    boolean includeSuiteSetup
 */
class ToDo1_Extract_a_Class_from_a_Big_Function {}

/**
 *  TODO 2 (Instanzvariablen aus einer lokalen Variablen Extrahieren und im Konstruktor initializieren)
 *
 *  Warum extrahieren wir Instanzvariablen aus den lokalen Variablen einer großen Funktion?
 *
 *  Normalerweise ist eine große Funktion in vielen Bereichen unterteilt
 *  Jeder Bereich ist wie ein Subfunktion, macht irgendeine Aufgabe
 *  diese Bereiche bearbeiten die lokalen Variablen.
 *  Wenn wir jeden Bereich in eine Subfunktion extrahieren,
 *  das müssen alle diese Subfunktionen die lokalen Variablen
 *  als Argumente haben. Was nicht so schön ist.
 *  Denn Funktionen sollten möglichst wenige Argumente haben!
 *
 *  Wenn diese lokale Variablen aber zu Instanzvariablen gemacht werden,
 *  dann müssen die Subfunktionen sie nicht als Argumente haben,
 *  denn alle Subfunktionen haben direkten Zugriff auf Instanzvariablen.
 *
 *
 *  Wie extrahieren wir Instanzvariablen aus lokalen Variablen?
 *  =============================================================
 *  Wir markieren die lokale Variable => RMK Refactor => Extract => Field.... 'Name eingeben'
 *
 *  * Beispiel: die Variable 'wikiPage' in invoke() function
 *  * 'wikiPage' in invoke() Methode markieren
 *  * RMK => Refactor => Extract => Field....
 *  * 'Choose Class to Introduce Field' => class 'TestableHtmlMaker' auswählen
 *  * Doppelklick auf wikiPage.
 *
 *  Die Variable wikiPage im Konstruktor initializieren:
 *  ======================================================
 *  Kopieren Sie: 'wikiPage = pageData.getWikiPage(); aus invoke()
 *  in den 'TestableHtmlMaker' Konstruktor rein.
 *
 *  Die gleichen Schritte führen Sie bitte für 'StringBuffer buffer' durch.
 */
class ToDo2_Extract_InstanceVariables_From_Local_Variables {}



public class MakeHTML {

    public static String testableHtml(PageData pageData, boolean includeSuiteSetup) throws Exception
    {
        WikiPage wikiPage = pageData.getWikiPage();
        StringBuffer buffer = new StringBuffer();
        if(pageData.hasAttribute("Test"))
        {
            if(includeSuiteSetup)
            {
                WikiPage suiteSetup = PageCrowlerImpl.getInheritedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
                if(suiteSetup != null)
                {
                    WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include -setup .").append(pagePathName).append("\n");
                }
            }
            WikiPage setup = PageCrowlerImpl.getInheritedPage("SetUp", wikiPage);
            if(setup != null){
                WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup);
                String setupPathName = PathParser.render(setupPath);
                buffer.append("!include -setup .").append(setupPathName).append("\n");
            }
        }
        buffer.append(pageData.getContent());
        if(pageData.hasAttribute("Test"))
        {
            WikiPage teardown = PageCrowlerImpl.getInheritedPage("TearDown", wikiPage);
            if(teardown != null){
                WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
                String tearDownPathName = PathParser.render(tearDownPath);
                buffer.append("!include -teardown .").append(tearDownPathName).append("\n");
            }
            if(includeSuiteSetup)
            {
                WikiPage suiteTeardown = PageCrowlerImpl.getInheritedPage(SuiteResponder.SUITE_TEARDOWN_NAME, wikiPage);
                if(suiteTeardown != null)
                {
                    WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteTeardown);
                    String pagePathName = PathParser.render(pagePath);
                    buffer.append("!include -teardown .").append(pagePathName).append("\n");
                }
            }
        }

        pageData.setContent(buffer.toString());
        return pageData.getHtml();
    }

}










