Nume: Pirvan Andra-Alexia
> Grupa: 335CB (refacere)
> Link GitHub: https://github.com/alexia-pirvan/poo-cd-project1/

# PROIECT (POO TV)- Etapa 1

* Solutia temei prezente a fost realizata in jurul clasei AppManager, care primeste de la Main
datele de input, prelucreaza, pe rand, comenzile (retinute prin obiecte de tip ActionInput),
si retine pentru fiecare in parte rezultatul, intr-ul obiect de tip ActionOutput, urmand ca
in final sa avem un ArrayList de ActionOutput.

* Pentru ca pe parcursul executarii comenzilor, datele initiale se schimba - ex: userii cumpara
token-uri, dau like-uri, iar filmele primesc rating-uri - am fost nevoita sa fac la fiecare rezultat
de comanda (on page/change page) un "deep copy" al obiectului, pentru ca in final, cand scriu in
fisierul JSON datele, acestea sa fie pastrate in stadiul in care au fost create, si nu modificate
de comenzile care au urmat.

* Pentru citirea input-ului m-am folosit de un obiect de tip ObjectMapper, care mi-a populat clasele
definite in enunt direct cu valorile din fisierele de intrare, prin faptul ca am tinut cont sa am numele
"instance variable"-elor identice cu numele cheilor din json. Similar, am facut afisarea cu ObjectWritter.

* Am incercat sa implementez design-pattern-ul Visitor. Mi s-a parut logic sa imi creez o interfata
PageAction, in care sa definesc doua metode abstracte, "onPage" si "changePage", care sa fie implementate
de fiecare pagina in functie de tipul acesteia. Am creat o clasa Page, care implementeaza aceasta interfata,
clasele efective extinzand-o.

* Clasa Browser, am creat-o pentru a retine status-ul datelor: filmele si userii platformei,
userul curent, impreuna cu filmele pe care acesta le poate vedea si pagina sa curenta. Prin metoda
run(ActionInput) primesc o comanda, si o transmit paginii curente pentru a fi executata si primesc inapoi
output-ul comenzii. In final, am implementat la fiecare pagina cele doua metode, in functie de cerinta.
