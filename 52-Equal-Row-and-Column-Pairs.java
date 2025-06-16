soru-


Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).

 

Example 1:


Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]

satırları :  3,2,1 / 1,7,6 / 2,7,7
kolonları: 3,1,2 / 2,7,7 / 1,6,7

2,7,7 ikisiinde de var ve başka ortak olmadığı için 1 döndük.

---------

benim o(n kare çözümüm): beats%10 :D

class Solution {
    public int equalPairs(int[][] grid) {
        // Satırları tutacak listeyi oluşturalım
        List<List<Integer>> rows = new ArrayList<>();
        
        // Her satır için döngü
        for (int i = 0; i < grid.length; i++) {
            // Her satır için yeni bir liste oluştur
            List<Integer> row = new ArrayList<>();
            
            // Bu satırdaki tüm değerleri ekle
            for (int j = 0; j < grid[i].length; j++) {
                row.add(grid[i][j]);
            }
            
            // Oluşturduğumuz satırı ana listeye ekle
            rows.add(row);
        }
        
        //---------------------------------------------------
        
        List<List<Integer>> columns = new ArrayList<>();
        int n = grid.length;
        
        // Her sütun için döngü
        for (int j = 0; j < n; j++) {
            // Her sütun için yeni bir liste oluştur
            List<Integer> column = new ArrayList<>();
            
            // Bu sütundaki tüm değerleri ekle
            for (int i = 0; i < n; i++) {
                column.add(grid[i][j]);
            }
            
            // Oluşturduğumuz sütunu ana listeye ekle
            columns.add(column);
        }
        
        //---------------------------------------------------
        
        int counter = 0;
        for(int i = 0; i < rows.size(); i++) {
            for(int j = 0; j < columns.size(); j++) {
                if(rows.get(i).equals(columns.get(j))) {
                    counter++;
                }
            }
        }
        
        return counter;
    }
}

----------------

yine n kare ama %85 beats bir map-set çözümüm:

public int equalPairs(int[][] grid) {
    int n = grid.length;
    Map<List<Integer>, Integer> rowMap = new HashMap<>();
    
    // Satırları sayalım ve HashMap'e ekleyelim
    for (int i = 0; i < n; i++) {
        List<Integer> row = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            row.add(grid[i][j]);
        }
        rowMap.put(row, rowMap.getOrDefault(row, 0) + 1);
    }
    
    // Sütunları kontrol edip eşleşmeleri sayayalım
    int count = 0;
    for (int j = 0; j < n; j++) {
        List<Integer> col = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            col.add(grid[i][j]);
        }
        count += rowMap.getOrDefault(col, 0);
    }
    
    return count;
}
