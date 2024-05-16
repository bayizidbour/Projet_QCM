# Projet_QCM

# bug bayizid
-  probleme:
    dans ton formulaire, lorsque tu cliques sur le bouton mis à jours, tu es rediriger vers la page " http://localhost:8080/quiz/update/admin/1 "
    or dans cette page si tu clique sur le bouton mis à jours, au lieu de faire la mis à jour, le programme insert un nouveau quiz.
- solution:
    pour pouvoir faire la mis à jour du quiz, il faut d'abord avoir l'id du quiz car dans cette page tu as déjà toutes les données il te manque juste
    l'id. car sans la présence de ce dernier , le programme effectuera une insertion lors que tu appelera la fonction save.
    donc ajoute  ce champ input qui récupère l'id de quiz dans ton formulaire de la page "quiz/index"
    ce champ nest pas visible mais disponible seulement l'id du quiz existe .
    				<input type="hidden" name="id" th:if="${quiz.getId()!=null}" th:value="${quiz.getId()}">

    et ton formulaire sera

    <div class=" card p-4 mt-5" style="width: 30%; margin: auto">
			<h2 class="">Add quiz [[${date_now}]]</h2>
			<form th:action="@{/admin/quiz/inserer}" method="post" th:object="${quiz}">
				<!--				Ce qui manquait -->
				<input type="hidden" name="id" th:if="${quiz.getId()!=null}" th:value="${quiz.getId()}">
				<div class="">
					<div class=" form-group mb-2">
						<input type="text" class="form-control" th:field="*{titre}" placeholder="Veillez entrer un titre" />
					</div>

					<div class=" form-group mb-2">
						<input type="number" class="form-control" th:field="*{duree}"
							placeholder="Veillez entrer la durée" />
					</div>
					<div class=" form-group mb-2">
						<input type="date" class="form-control" th:field="*{date_debut}" th:min="${date_now}"
							placeholder="Veillez entrer la date de debut" />
					</div>
					<div class=" form-group mb-2">
						<input type="date" class="form-control" th:field="*{date_expiration}" th:min="${date_now}"
							placeholder="Veillez entrer la date d'expiration" />
					</div>

				</div>

				<div class=" form-group">
					<button type="submit" class="btn btn-success form-control">Ajouter/Modifier Quiz</button>
				</div>

			</form>
