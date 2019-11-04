package Kata01.V12;

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

/**
 *  ToDo 4 (Duplikate eliminieren: Don't Repeate yourself Principle (DRY) )
 *  TODO 4 ( Extract out the four repeating groups into a single function )
 *
 *  Markieren Sie die folgenden 3 Zeilen von dieser repeating groups
 *
 *   * WikiPagePath pagePath = crawler.getFullPath(suiteSetup);
 *   * String pagePathName = PathParser.render(pagePath);
 *   * content.append("!include -" + mode + " .").append(pagePathName).append("\n");
 *
 *   * RMB => Refactor => Extract Methode....=> Name: 'includePage'
 *   * Parameters:
 *      String mode
 *      WikiPage suiteSetup zu page ändern
 *
 *   * IDE Message: Process Duplicate 1 of 3 Do You want to replace this occurrence?
 *   * => Replace 3 mal bestätigen
 *
 */
class ToDo4_Extract_Similar_Repeating_Groups{}

/**
 *  TODO 5 ( Clean the extracted Function 'includePage' up )
 *
 *  1) z.B geschweifelte Klammer { } weg. sind überflüssig
 *  2) String.format Methode benutzen.
 *  * content.append("!include -" + mode + " .").append(pagePathName).append("\n");
 *  Ersetzten durch:
 *  * content.append(String.format("!include -%s .%s\n", mode, pagePathName))
 */
class ToDo5_Clean_Up_The_Extracted_Private_Function_includePage{}

/**
 *  TODO 6 (Eliminiere die neue entstandene 'Repeating Structue')
 *
 *  Der folgende Code-Block kommt auch 4 mal vor und zwar in ähnlichen Varianten mit 4 Instanzen
 *
 *  *  WikiPage suiteSetup = PageCrowlerImpl.getInheritedPage(SuiteResponder.SUITE_SETUP_NAME, wikiPage);
 *  *  if(suiteSetup != null)
 *  *  includePage(mode, suiteSetup);

 *  * WikiPage setup = PageCrowlerImpl.getInheritedPage("SetUp", wikiPage);
 *  *  if(setup != null)
 *  * includePage(mode, setup);

 *  *  WikiPage teardown = PageCrowlerImpl.getInheritedPage("TearDown", wikiPage);
 *  *   if(teardown != null)
 *  *  includePage(mode, teardown);

 *  *  WikiPage suiteTeardown = PageCrowlerImpl.getInheritedPage("TearDown", wikiPage);
 *  *   if(suiteTeardown != null)
 *  *  includePage(mode, suiteTeardown);
 *

 *  Um die Duplikate hier auch zu eliminieren müssen wir wie ToDo 3 und 4 machen:
 *
 *  * Code-Block 'Parameteric' machen:
 *  ==================================
 *  Wir müssen jedes Block "parameteric" machen, in dem wir eine Variable raus extrahieren.
 *  welche die Page name representiert:
 *
 *   * 'SuiteResponder.SUITE_SETUP_NAME' markieren => Refactor => Extract => Variable => pageName
 *   * 'SetUp' markieren => Refactor => Extract => Variable => pageName
 *   * 'TearDown' markieren => Refactor => Extract => Variable => pageName
 *   * 'SuiteResponder.SUITE_TEARDOWN_NAME' markieren Refactor => Extract => Variable => pageName

 *   * Function raus extrahieren
 *   ================================
 *    Anschließend können wir alle diese 'repeating version'
 *    in eine einzige Funktion 'includeIfInherited' raus extrahieren:
 *    Code Block markieren => Refactor => Extract => Method.. =>name: includeIfInherited
 *    Die IDE erkennt, dass eine 'repeating structure' noch 3 mal existiert und fragt:
 *    " Do you want to replace this occurence" ?
 *    4x Yes bestätigen.
 *
 *    Nun können wir die Variable pageName in dem Aufruf :
 *    * includeIfInherited(mode, pageName);
 *
 *    mit den Namen: 'SuiteResponder.SUITE_SETUP_NAME'
 *    "SetUp", "TearDown", SuiteResponder.SUITE_TEARDOWN_NAME
 *    und löschen wir String pageName Variable
 *    Anschliessend entfernen wir unnötige { } von if
 */
class ToDo6_Eleminate_Duplicate{}

/**
 *    TODO 7 ( Clean up includeIfInherited Function)
 *
 *    Nun können wir die Lesbarkeit von der privaten Funktion
 *    includeIfInherited ein bisschen Verbesseren
 *
 *    z.B. die Variable Name suiteSetup umbennen.
 *    'suiteSteup' markieren => Refactor => Rename => page
 */
class ToDo7_Clean_up_The_Extracted_Private_Function_includeIfInherited{}

/**
 *    TODO 8 (Inline local Varialbes: 'pageName' und 'mode' )
 *
 *    Inline local Variable 'pageName'
 *    ================================
 *    Nun können wir die Variable 'pageName' in dem Aufruf :
 *    * includeIfInherited(mode, pageName);
 *
 *    mit den Namen: 'SuiteResponder.SUITE_SETUP_NAME' "SetUp", "TearDown", SuiteResponder.SUITE_TEARDOWN_NAME
 *    die Reihe nach ersetzen und löschen wir String pageName Variable. Dies geht mit:
 *
 *    * 'pageName' markieren => Refactor => Inline ...
 *
 *    Anschliessend entfernen wir unnötige { } von if
 *
 *    Inline local Variable 'mode'
 *    ==============================
 *
 *    Mit der Variable 'mode' können wir das gleiche
 *    machen wie mit der Variable String pageName
 *    das heißt ersetzen wir die String mode mit
 *    ihrem Wert in dem Aufruf
 *    * includeIfInherited(mode, ...)
 *    * mode hat die Were: "setup" "TearDown"
 *
 *    * 'mode' markieren => Refactor => Inline ...
 *    * Local Variable Inline: "Inline all references  and remove the Variable (2 Occurences).
 *
 *
 */
class ToDo8_Inline_Variable{}

/**
 *    TODO 9 (If-Statment Body in Funktionen extrahieren)
 *
 *    Jetzt können wir die Haupt Funktionalität/Operationen in separten
 *    Funktionen mit sehr guten aussagekräftigen Namen raus extrahieren
 *    und zwar jeweils das 'body' von if(pageDate.hastAttribute("Test").
 *
 *    Zuerst extrahieren wir das erste if-Statement body in die Function: 'includeSetups'
 *    ====================================================================================
 *  *    if(includeSuiteSetup)
 *  *      includeIfInherited("setup", SuiteResponder.SUITE_SETUP_NAME);
 *  *    includeIfInherited("setup", "SetUp");
 *
 *   Also wir extrahieren das Block, welche die "setups" inkludiert
 *   in eine Funktion 'includeSetups'. Dafür das Block markieren

 *  * Block markieren => Refactor => Extract => Method.... => includeSetups
 *  * Anschliessend löschen wir überflüssige {}

 *   Dann extrahieren wir das zweite if-Statement body in die Function: 'includeTeardowns'
 *   ====================================================================================
 *   Analog dazu extrahieren wir den Code, der "teardowns" inkludiert
 *   in eine Function "includeTeardowns" in dem wir den folgenden Block markieren>
 *
 *  * includeIfInherited("teardown", "TearDown");
 *  *    if(includeSuiteSetup)
 *  * includeIfInherited("teardown", SuiteResponder.SUITE_TEARDOWN_NAME);
 *
 *  Code Block markieren => Refactor => Extract => Method...=> 'includeTeardowns'
 *  Anschliessend löschen wir überflüssige {}
 *
 */
class ToDo9_If_Statment_Body_In_Function_Extrahieren{}

/**
 *  TODO 10 (StringBuffer Code eliminieren )
 *
 *  Die StringBuffer variable wurde nur benutzt um
 *  Strings aneinander anzuhängen, wir können sie
 *  elimineren. Dafür lassen wir unsere hilfsfunktionen
 *  String zurück lieferen und sie anschliessend in invoke mit "+" verketten
 *
 *  1) Wir ändern die Return-Value von includeIfInherited
 *    von 'void' zu 'String' und lassen die Methode ein Exception werfen.
 *    private String includeIfInherited(...) throws Exception {
 *        return includePage(mode, page));
 *    }
 *
 *  2) Wir ändern nun auch includePage(mode, page) von void zu String
 *     private String includePage(mode, page) throws Exception {
 *         // content.append(String.format("!include -%s .%s\n", mode, pagePathName));
 *         return String.format("!include -%s .%s\n", mode, pagePathName));
 *     }
 *
 *  3) Wir bennen die Variable StringBuffer content in 'String content' um.
 *     buffer Variable markieren => RMT => Refactor => Rename => 'content'
 *     und ändern Ihren Typen anschließend zu String. und passen folgenden Code
 *      content = new StringBuffer(); zu content = "" ;
 *
 *  4) in includeSetups:  speichern und verketten wir das Ergebnis von includeIfInherited in Content
 *
 *      content += includeIfInherited("setup", SuiteResponder.SUITE_SETUP_NAME);
 *      content +=      includeIfInherited("setup", "SetUp");
 *
 *
 *  5)  Analog in includeTeardowns: speichern wir auch das Ergebnis von includeIfInherited
 *      und verketten es in Content.
 *
 *       content += includeIfInherited("teardown", "TearDown");
 *             if(includeSuiteSetup)
 *                 content += includeIfInherited("teardown", SuiteResponder.SUITE_TEARDOWN_NAME);
 *
 *  6) Das Endergebnis in die invoke() mit "+" zusammen verketten.
 *    wir ersetzen den Code: content.append(pageData.getContent());
 *    durch                  content += pageData.getContent();
 *
 *     content += includeSetups();
 *     content += includeTeardowns();
 *
 *  7) Dafür ändern wir den Rückgabetyp von includeTeardown von void zu String
 *    wir  definieren eine locale Varialbe String teardown = "";
 *
 *     private String includeTeardowns() throws Exception{
 *             String teardowns = "";
 *             teardowns += includeIfInherited("teardown", "TearDown");
 *             if(includeSuiteSetup)
 *                 teardowns += includeIfInherited("teardown", SuiteResponder.SUITE_TEARDOWN_NAME);
 *             return teardowns;
 *         }
 *
 *
 *  8) Das gleiche machen wir mit includeSetups.
 *     Sinn ist, alle kleinen Funktionen in invoke() verketten.
 *     In includeSetups() die lokale Variable String content definieren
 *     content markieren => RMT => Rename => 'setups'
 *
 *
 *  9) Jetzt ist die Logik von invoke() function klar und deutlich
 *  wir können diesen Code noch weiter verfeinern, in dem wir
 *  alle 'content-altering code' innerhalb eine einzige if-statment rein tun.
 *  und die untere if-statment löschen, da sie beide gleich sind!
 *  Anschliessend Code formatieren. Code markieren => Code => Reformat Code
 *
 */
class ToDo10_StringBuffer_Instanzvariable_in_String_Instanzvariable_umwandeln {}


/**
 *
 *  ToDo 11 (Extract the Predicate of the if Statement into a Method & the body of the if Statement into a method)
 *
 *  jetzt können wir das Prädikat, also den boolschen Ausdruck in
 *  die if-Statment in der invoke() method in eine eigne Methode extrahieren:
 *
 *   * if(pageData.hasAttribute("Test")
 *   * pageDate.hasAttribte("Test") markieren => Refactor => Extract => Method....=> name: istTestPage()
 *
 *  Also das Body von if(isTestPage()){
 *       content += includeSetups();
 *       content += pageData.getContent();
 *       content += includeTeardowns();
 *       pageData.setContent(content.toString());
 *  }
 *
 *  markieren => RMT => Refactor => Extract => Method => 'surroundPageWithSetupsAndTeardowns'
 *  Anschließend überflüssige { } löschen
 *
 */
class ToDo11_Extract_If_Statment_Predicate_Into_isMethod{}


/**
 *  ToDo 12 (Rename the inner class and the invoke() function )
 *
 *  Die Invoke Function sagt uns jetzt genau, was er tut!
 *  auch alle anderen Funktionen sagen was sie genau tun!
 *  Denn alle sind: small, simple, well-names functions
 *
 *  Die innere Class umhüllt (surround) eine 'test page'
 *  mit 'setups' und 'teardowns'
 *
 *  Wir nennen die innere Class TestableHtmlMaker zu 'SetupTeardownSurrounder' um
 *  'TestableHtmlMaker' markieren => RMT => Refactor => Rename => 'SetupTeardownSurrounder'
 *
 *  Wir nnen die Methode invoke() zu surround() um
 *  invoke() markieren => RMT => Refactor => Rename => 'surround'
 *
 *  Unser Code ist jetzt wie ein "Well-Written Prose"
 */
class ToDo12_Rename_the_inner_Class_and_invok{}



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










