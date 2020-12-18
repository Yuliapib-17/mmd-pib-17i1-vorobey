
    public class l3 {
        public static void main(String[] args) {
            if (args.length > 3) {
                System.out.println("Введено больше трёх переменных");
                return;
            }
            if (args.length == 0) {
                System.out.println("Введите переменные");
                return;
            }
            if (args.length < 3) {
                System.out.println("Введено меньше трёх переменных");
            }

            try {
                double x = Double.parseDouble(args[0]);
                double y = Double.parseDouble(args[2]);
                char operation = args[1].charAt(0);
                if (operation == '/' && -1e-12 < y && y < 1e-12) {
                    System.out.println("Деление на 0 запрещено");
                    return;
                }
                System.out.println("Итого: " + calc(x, y, operation));

            } catch (NumberFormatException exeptionObject) {
                System.out.println("Введите числа");
            }
        }

        private static double calc(double x, double y, char operation) {
            switch (operation) {
                case '+':
                    return x + y;
                case '-':
                    return x - y;
                case '*':
                    return x * y;
                case '/':
                    return x / y;
            }
            return 0;
        }
    }
