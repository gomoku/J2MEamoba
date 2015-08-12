
public class Jatek {
	public static int WinsGame( int i0, int j0, int[][] tabla) {
		int i, j;
		i = i0;
		j = j0-3; if( j < 0 ) j = 0;
		while( (j <= j0) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i][j+1] == tabla[i0][j0]) &&
				(tabla[i][j+2] == tabla[i0][j0]) &&
				(tabla[i][j+3] == tabla[i0][j0]) )
				return 1;
			j++;
		}
		j = j0;
		i = i0-3; if( i < 0 ) i = 0;
		while( i<=i0 ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j] == tabla[i0][j0]) &&
				(tabla[i+2][j] == tabla[i0][j0]) &&
				(tabla[i+3][j] == tabla[i0][j0]) )
				return 1;
			i++;
		}
		j = j0-3; i = i0-3;
		while(i<0 || j<0){ j++; i++;}
		while( (i <= i0) && (j <= j0)) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j+1] == tabla[i0][j0]) &&
				(tabla[i+2][j+2] == tabla[i0][j0]) &&
				(tabla[i+3][j+3] == tabla[i0][j0]) )
				return 1;
			j++; i++;
		}
		j = j0+3; i = i0-3; if(i<0) i=0;
		while( j<0 || i<0) { j--; i++; }
		while( (i <= i0) && (j >= j0) && (j >= 3) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j-1] == tabla[i0][j0]) &&
				(tabla[i+2][j-2] == tabla[i0][j0]) &&
				(tabla[i+3][j-3] == tabla[i0][j0]) )
				return 1;
			j--; i++;
		}
		return 0;
	}
	public static int WinsGame2( int i0, int j0, int[][] tabla ) {
		int i, j;
		/* Lenne-e 4 darab egymás mellett?*/
		i = i0;
		j = j0-3; if( j < 0 ) j = 0;
		while( (j <= j0)) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i][j+1] == tabla[i0][j0]) &&
				(tabla[i][j+2] == tabla[i0][j0]) &&
				(tabla[i][j+3] == tabla[i0][j0]) )
				return 1;
			j++;
		}
		j = j0;
		i = i0-3; if( i < 0 ) i = 0;
		while( (i <= i0)) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j] == tabla[i0][j0]) &&
				(tabla[i+2][j] == tabla[i0][j0]) &&
				(tabla[i+3][j] == tabla[i0][j0]) )
				return 1;
			i++;
		}
		j = j0-3; i = i0-3;
		while(j<0 || i<0){i++; j++;}
		while( (i <= i0) && (j <= j0)) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j+1] == tabla[i0][j0]) &&
				(tabla[i+2][j+2] == tabla[i0][j0]) &&
				(tabla[i+3][j+3] == tabla[i0][j0]) )
				return 1;
			j++; i++;
		}
		j = j0+3; i = i0-3;
		while(i<0){i++; j--;}
		while( (i <= i0) && (j >= j0) && (j >= 3) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j-1] == tabla[i0][j0]) &&
				(tabla[i+2][j-2] == tabla[i0][j0]) &&
				(tabla[i+3][j-3] == tabla[i0][j0]) )
				return 1;
			j--; i++;
		}
		return 0;
	}
public static int WinsGame4( int i0, int j0, int[][] tabla ) {
	int i, j;
			/* Nyertne-e? kijött-e 5 darab egymás mellett?*/
			i = i0;
			j = j0-4; if( j < 0 ) j = 0;
			while( (j <= j0) ) {  //függõlegesen kijön-e
				if( (tabla[i][j] == tabla[i0][j0]) &&
					(tabla[i][j+1] == tabla[i0][j0]) &&
					(tabla[i][j+2] == tabla[i0][j0]) &&
					(tabla[i][j+3] == tabla[i0][j0])  &&
					(tabla[i][j+4] == tabla[i0][j0]))
					return 1;
				j++;
			}
			j = j0;
			i = i0-4; if( i < 0 ) i = 0;
			while( (i <= i0) ) { //vízszintesen kijön-e
				if( (tabla[i][j] == tabla[i0][j0]) &&
					(tabla[i+1][j] == tabla[i0][j0]) &&
					(tabla[i+2][j] == tabla[i0][j0]) &&
					(tabla[i+3][j] == tabla[i0][j0])  &&
					(tabla[i+4][j] == tabla[i0][j0]))
					return 1;
								i++;
			}
			j = j0-4; i = i0-4;
			while(i<0 || j<0){ i++; j++; }
			//if(i<0) i=0; if(j<0) j=0;
			while( (i <= i0) && (j <= j0)) { //jobbra le átlósan kijön-e
				if( (tabla[i][j] == tabla[i0][j0]) &&
					(tabla[i+1][j+1] == tabla[i0][j0]) &&
					(tabla[i+2][j+2] == tabla[i0][j0]) &&
					(tabla[i+3][j+3] == tabla[i0][j0])  &&
					(tabla[i+4][j+4] == tabla[i0][j0]))
					return 1;
				j++; i++;
			}
			j = j0+4; i = i0-4;
			while(i<0){ i++; j--;}
			//if(i<0) i=0; //bal lentrõl átlósan jobbra fel
			while( (i <= i0) && (j >= j0) && (j >= 4) ) {
				if( (tabla[i][j] == tabla[i0][j0]) &&
					(tabla[i+1][j-1] == tabla[i0][j0]) &&
					(tabla[i+2][j-2] == tabla[i0][j0]) &&
					(tabla[i+3][j-3] == tabla[i0][j0])  &&
					(tabla[i+4][j-4] == tabla[i0][j0]))
					return 1;
				j--; i++;
			}
			return 0;

	}
public static int WinsGame3( int i0, int j0, int[][] tabla ) {
		int i, j;
		/* Tesztelés: ha 3 darab lenne egymás mellett */
		i = i0;
		j = j0-2; if( j < 0 ) j = 0;
		while( (j <= j0) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i][j+1] == tabla[i0][j0]) &&
				(tabla[i][j+2] == tabla[i0][j0]))
				return 1;
			j++;
		}
		j = j0;
		i = i0-2; if( i < 0 ) i = 0;
		while( (i <= i0) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j] == tabla[i0][j0]) &&
				(tabla[i+2][j] == tabla[i0][j0]))
				return 1;
			i++;
		}
		j = j0-2; i = i0-2;
		while(i<0 || j<0){i++; j++;}
		while( (i <= i0) && (j <= j0)) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j+1] == tabla[i0][j0]) &&
				(tabla[i+2][j+2] == tabla[i0][j0]))
				return 1;
			j++; i++;
		}
		j = j0+2; i = i0-2;
		while(j<0 || i<0){i++; j--;}
		while( (i <= i0) && (j >= j0) && (j>=2) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j-1] == tabla[i0][j0]) &&
				(tabla[i+2][j-2] == tabla[i0][j0]))
				return 1;
			j--; i++;
		}
		return 0;
	}
public static int WinsGame5( int i0, int j0, int[][] tabla) {
		int i, j;
		/* Tesztelés hogy ha ide tesz van-e mellette másik */
		i = i0;
		j = j0-1; if( j < 0 ) j = 0;
		while( (j <= j0) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i][j+1] == tabla[i0][j0]))
				return 1;			j++;
		}
		j = j0;
		i = i0-1; if( i < 0 ) i = 0;
		while( (i <= i0) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j] == tabla[i0][j0]))
				return 1;
			i++;
		}
		j = j0-1; i = i0-1;
		while(i<0 || j<0){ i++; j++; }
		while( (i <= i0) && (i <= 9) && (j <= j0) && (j <= 9) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j+1] == tabla[i0][j0]))
				return 1;
			j++; i++;
		}
		j = j0+1; i = i0-1; //if(i<0) i=0;
		while(i<0){j--; i++;}
		while( (i <= i0) && (i <= 9) && (j >= j0) && (j >= 1) ) {
			if( (tabla[i][j] == tabla[i0][j0]) &&
				(tabla[i+1][j-1] == tabla[i0][j0]) )
				return 1;
			/* ha nemsikerül tovább próbáljon */
			j--; i++;
		}
		/* Ha nincs ilyen sorozat */
		return 0;
	}
}