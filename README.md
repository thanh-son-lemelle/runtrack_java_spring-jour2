# 🧪 runtrack_java_spring - Jour 2

## 🧩 Job 01 – Modèle MVC dans Spring Boot

### ❓ Question : Comment le modèle MVC aide-t-il à structurer une application web ?

➡️ Il sépare clairement :
- La logique métier (**Model**)
- La logique de présentation (**View**)
- Le traitement des requêtes (**Controller**)

---

## 🧩 Job 02 – Créer un contrôleur et une vue

### ❓ Question : Quelle est la différence entre Thymeleaf et les templates HTML classiques ?

➡️ **Thymeleaf** permet l’intégration dynamique des données du backend avec des balises `th:*`.  
Un template HTML classique est **statique**, sans logique serveur.

---

## 🧩 Job 03 – Liste dynamique avec Thymeleaf

### ❓ Question : Comment pouvez-vous passer des données d'un contrôleur à une vue dans Spring ?

➡️ Dans Spring, on utilise l'objet `Model` pour passer des données du contrôleur à la vue.

### ✅ Exemple :

```java
@GetMapping("/bonjour")
public String direBonjour(Model model) {
    model.addAttribute("nom", "Alice");
    return "bonjour";
}
```
### 📄 Vue `bonjour.html` :

```html
<p th:text="'Bonjour ' + ${nom}">Message</p>
```

### 🧠 Explication :

- `model.addAttribute("nom", "Alice")` ajoute une variable `nom` à la vue.
- Dans le HTML, `th:text="${nom}"` affiche dynamiquement la valeur.

---

### 💡 Résumé :

| Élément              | Rôle                                       |
|----------------------|---------------------------------------------|
| `Model`              | Conteneur pour passer des données à la vue |
| `addAttribute()`     | Ajoute une clé/valeur dans le modèle       |
| `${...}` dans la vue | Accède aux données avec Thymeleaf          |

---

## 🧩 Job 04 – Formulaire simple + message de bienvenue

### ❓ Question : Comment Spring facilite-t-il la gestion des formulaires ?

| Fonctionnalité              | Description                                                   |
|-----------------------------|---------------------------------------------------------------|
| `@GetMapping`, `@PostMapping` | Distingue l'affichage du formulaire et son traitement        |
| `@RequestParam`             | Récupère les champs soumis dans le contrôleur                |
| `Model`                     | Permet d’envoyer des données à la vue                        |
| **Thymeleaf**               | Permet de lier les champs HTML aux données automatiquement   |

➡️ **Résultat** : peu de code nécessaire pour lier un formulaire HTML à la logique Java.  
Spring fait la liaison automatiquement.

---

## 🧩 Job 05 – Ajouter champ âge + validation

### ❓ Question : Comment Spring permet-il la validation des données du formulaire ?

Spring facilite la validation des formulaires en combinant :

- ✅ des annotations Java (`@NotEmpty`, `@Min`, etc.)
- ✅ l’annotation `@Valid` dans le contrôleur
- ✅ la récupération des erreurs via `BindingResult`
- ✅ l’affichage des erreurs dans la vue avec `th:errors`

Cette approche permet une validation :

- ✅ **automatique**  
- ✅ **centralisée**  
- ✅ **facile à maintenir**

---

### 💡 Exemple

#### 🎯 Contrôleur :

```java
@PostMapping("/formValidate")
public String submitFormValid(
    @Valid @ModelAttribute("formData") FormData formData,
    BindingResult result,
    Model model) {
    
    if (result.hasErrors()) {
        return "formValidate";
    }

    model.addAttribute("message", "Bienvenue " + formData.getNom());
    return "formResult";
}
```

```html
<p th:if="${#fields.hasErrors('nom')}" th:errors="*{nom}"></p>
```

