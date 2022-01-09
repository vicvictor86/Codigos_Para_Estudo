from django.contrib import admin
from django.urls import path
from django.urls.conf import include
from escola.views import AlunosViewSet, CursosViewSet, ListaAlunosMatriculadosEmCurso, ListaMatriculaAluno, MatriculaViewSet
from rest_framework import routers

router = routers.DefaultRouter()
router.register('alunos', AlunosViewSet, basename='Alunos')
router.register('cursos', CursosViewSet, basename='Cursos')
router.register('matriculas', MatriculaViewSet, basename='Matriculas')

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include(router.urls)),
    path('aluno/<int:pk>/matriculas/', ListaMatriculaAluno.as_view()),
    path('curso/<int:pk>/alunos/', ListaAlunosMatriculadosEmCurso.as_view()),
]