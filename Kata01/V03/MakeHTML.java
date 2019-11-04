package Kata01.V03;

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

/**
 *  TODO 3 (Vorbereitung: Duplikate eliminieren: Don't Repeate yourself Principle (DRY) )
 *  TODO 3 (Vorbereitung: Repeating Structure identifizieren und auf ähnliche Form bringen)
 *
 *  'Repeating Structure' ist eine Fehlerquelle im Code.
 *  'Repeating Structure' verletzt das Don't Repeate Yourself Principle (DRY)
 *
 *  Manchmal kommt dergleiche Code-Block mehrfach im Code vor,
 *  Meist aber kommt dieser Code-Block in verschiedenen Versionen,
 *  die voneinander geringfügig unterscheiden.
 *
 *  zum Beispiel, der folgende Code kommt in sehr ähnlichen Versionen 4 mal vor.
 *
 *  *  WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteSetup);
 *  *  String pagePathName = PathParser.render(pagePath);
 *  *  content.append("!include -setup .").append(pagePathName).append("\n");
 *
 *  *  WikiPagePath setupPath = wikiPage.getPageCrawler().getFullPath(setup);
 *  *  String setupPathName = PathParser.render(setupPath);
 *  *  buffer.append("!include -setup .").append(setupPathName).append("\n");
 *
 *  *  WikiPagePath tearDownPath = wikiPage.getPageCrawler().getFullPath(teardown);
 *  *  String tearDownPathName = PathParser.render(tearDownPath);
 *  *  buffer.append("!include -teardown .").append(tearDownPathName).append("\n");
 *
 *  *  WikiPagePath pagePath = wikiPage.getPageCrawler().getFullPath(suiteTeardown);
 *  *  String pagePathName = PathParser.render(pagePath);
 *  *  buffer.append("!include -teardown .").append(pagePathName).append("\n");
 *
 *
 *  Dieser Code verletzt das Prinzip: Don't Repeate Yourself
 *  Um solche Duplikate zu eleminieren, muss man in der Vorbereitungsphase
 *  die Unterschiede eliminieren. (Eliminate Differences),
 *  in dem man ähnliche Code-Fragemente in Variablen raus extrahiert.
 *
 *   *  Schritt 1: Gleiches Code-Fragment bestimmen, in eine Instanzvariable raus extrahieren,
 *     (z.B. gleicher Methodenauruf, der ein Object zurück liefert)
 *     anschließend die extrahierte Instanzvariable im Konstruktor initializieren.
 *
 *   * Beispiel: wikiPage.getPageCrawler()
 *   * wikiPage.getPageCrawler() markieren
 *   * RMK => Refactor => Extract => Variable => Field... => 'crawler'
 *   * Im Konstuktor initializieren:
 *   * crawler =  wikiPage.getPageCrawler();
 *
 *   * Schritt 2: Ähnliche Code-Fragmente  bestimmen und in lokale Variablen extrahieren:
 *   * Code-Fragment markieren => RMK => Refactor => Extract => Variable => 'Gleicher Name bei allen Fragmenten'
 *
 *   * Beispiele
 *   * ("!include -setup .")     =>   "setup" markieren => RMK => Refactor => Extract => Variable => 'mode'
 *   * 'Replace all occurrences' auswählen.
 *
 *   * ("!include -teardown .")  =>   "teardown" markieren => RMK => Refactor => Extract => Variable => 'mode'
 *   * 'Replace all occurrences' auswählen.
 *
 *   Dadurch haben wir die Konstanten 'parameteric' gemacht und alle
 *   4 'repeating structure auf ähnliche Form gebracht'
 *
 *  *  String mode = "setup";
 *  *  WikiPagePath pagePath = crawler.getFullPath(suiteSetup);
 *  *  String pagePathName = PathParser.render(pagePath);
 *  *  content.append("!include -" + mode + " .").append(pagePathName).append("\n");

 *  *  String mode = "setup";
 *  *  WikiPagePath setupPath = crawler.getFullPath(setup);
 *  *  String setupPathName = PathParser.render(setupPath);
 *  *  buffer.append("!include -" + mode + " .").append(setupPathName).append("\n");

 *  *  String mode = "teardown";
 *  *  WikiPagePath tearDownPath = crawler.getFullPath(teardown);
 *  *  String tearDownPathName = PathParser.render(tearDownPath);
 *  *  buffer.append("!include -" + mode + " .").append(tearDownPathName).append("\n");

 *  *  String mode = "teardown";
 *  *  WikiPagePath pagePath = crawler.getFullPath(suiteTeardown);
 *  *  String pagePathName = PathParser.render(pagePath);
 *  *  buffer.append("!include -" + mode + " .").append(pagePathName).append("\n");
 *
 */
class ToDo3_Eliminate_Duplicate_Preperation {}



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










