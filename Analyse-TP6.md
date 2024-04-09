# Projet Pokémon : L'Influence de la Team Rocket

Ce projet intègre une implémentation unique de la `RocketPokemonFactory`, inspirée par les manigances de la Team Rocket. Contrairement aux usines Pokémon traditionnelles, cette usine crée des Pokémon avec des caractéristiques inattendues et parfois trompeuses. Cet aspect du projet souligne l'importance de tests robustes pour détecter des comportements inattendus dans les logiciels.

## Caractéristiques Sournoises de la Team Rocket

- **Pokémon Spéciaux** : La `RocketPokemonFactory` peut générer des Pokémon spéciaux comme "Ash's Pikachu" avec des statistiques exagérément élevées, ainsi que le mystérieux "MISSINGNO", connu pour ses bugs dans les jeux originaux.

- **Statistiques Aléatoires** : Les Pokémon créés par cette usine ont des statistiques d'attaque, de défense et de stamina générées aléatoirement, reflétant la nature imprévisible de la Team Rocket.

- **Comportement Spécial pour des Indices Négatifs** : Lorsque l'indice du Pokémon est négatif, la fabrique attribue des valeurs fixes exagérées pour simuler des Pokémon surpuissants.

## Stratégies de Test

Pour assurer la qualité et la prévisibilité de notre application, malgré les espiègleries de la Team Rocket, des tests spécifiques ont été mis en place :

### Détection des Pokémon Spéciaux

Un test vérifie que les Pokémon avec des indices spécifiques (`-1` pour "Ash's Pikachu", `0` pour "MISSINGNO") sont correctement générés avec les attributs attendus.

### Validation des Statistiques

Des tests s'assurent que les statistiques générées aléatoirement se situent dans une plage acceptable et ne dépassent pas les limites supposées des capacités des Pokémon.

### Gestion des Indices Négatifs

Un test confirme que tout indice négatif conduit à la création d'un Pokémon avec des statistiques et IV prédéterminés, démontrant ainsi le comportement intentionnellement trompeur de la Team Rocket.

## Conclusion

L'intégration des manigances de la Team Rocket dans ce projet soulève des défis intéressants pour l'assurance qualité. Les tests automatisés jouent un rôle crucial pour débusquer les comportements inattendus et assurer que même les plus sournoises des implémentations restent sous contrôle.
