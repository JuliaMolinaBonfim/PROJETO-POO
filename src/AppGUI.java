package src;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AppGUI extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;

    private Zoologico zoologico;

    public AppGUI() {
        setTitle("Zoo das Poderosas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        montarZoologico();

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        cards.add(criarHomePanel(), "home");
        cards.add(criarCadastroPanel(), "cadastro");
        cards.add(criarAnimaisPanel(), "animais");

        add(cards);
        cardLayout.show(cards, "home");

        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }


    private void montarZoologico() {
        zoologico = new Zoologico("Zoo das Poderosas");
        zoologico.adicionarAnimal(new Hipopotamo("Juju", 7, 1500, "cinza", true,
                "rio", 3.5 , false, "andar", false, "herbívoro", "50s"));

        zoologico.adicionarAnimal(new Macaco("Kiki", 3, 35, "marrom", true,
                "floresta", 1.2 , false, "pular", true, "onívoro", "12cm"));

        zoologico.adicionarAnimal(new Cobra("Naja", 4, 6.2, "laranja", true,
                "floresta", 1.5, false, "rastejar", true, "escamosa", true, "Jiboia"));

        zoologico.adicionarAnimal(new Jacare("Guto", 9, 300, "verde escuro", true,
                "pântano", 2.5, false, "nadar", false, "escamosa", true, "50"));

        zoologico.adicionarAnimal(new Girafa("Alex", 8, 800, "Amarela e Preta", true, "Terrestre", 1, false,
                "Patas", false, "Folhas", 30));
    }

    private JPanel criarHomePanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(new Color(245, 245, 245));

        JLabel titulo = new JLabel("Bem-vindo ao Zoo das Poderosas!", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 28));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        p.add(titulo, BorderLayout.NORTH);

        JPanel botoes = new JPanel(new GridBagLayout());
        botoes.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 20, 10, 20);

        JButton btnCadastrar = new JButton("Cadastrar Visitante!");
        btnCadastrar.setPreferredSize(new Dimension(300, 80));
        btnCadastrar.setFont(new Font("SansSerif", Font.BOLD, 20));
        btnCadastrar.addActionListener(e -> cardLayout.show(cards, "cadastro"));
        btnCadastrar.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        JButton btnAnimais = new JButton("Conheça Nossos Animais!");
        btnAnimais.setPreferredSize(new Dimension(300, 80));
        btnAnimais.setFont(new Font("SansSerif", Font.BOLD, 20));
        btnAnimais.setFocusPainted(false);
        btnAnimais.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        btnAnimais.addActionListener(e -> {
            cards.remove(cards.getComponent(2));
            cards.add(criarAnimaisPanel(), "animais");
            cardLayout.show(cards, "animais");
        });

        c.gridx = 0; c.gridy = 0;
        botoes.add(btnCadastrar, c);
        c.gridx = 0; c.gridy = 1;
        botoes.add(btnAnimais, c);

        p.add(botoes, BorderLayout.CENTER);

        JLabel footer = new JLabel("© Zoo das Poderosas", SwingConstants.CENTER);
        footer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p.add(footer, BorderLayout.SOUTH);

        return p;
    }

    private JPanel criarCadastroPanel() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6, 6, 6, 6);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1;

        JLabel lblTitle = new JLabel("Cadastrar Visitante");
        lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
        p.add(lblTitle, BorderLayout.NORTH);

        JLabel nomeL = new JLabel("Digite seu nome:");
        JTextField nomeF = new JTextField();

        JLabel cpfL = new JLabel("Digite seu CPF:");
        JTextField cpfF = new JTextField();

        JLabel nascL = new JLabel("Digite sua data de nascimento:");
        JTextField nascF = new JTextField();

        JLabel visitaL = new JLabel("Digite a data da visita:");
        JTextField visitaF = new JTextField();

        JLabel horaL = new JLabel("Digite a sua hora de entrada:");
        JTextField horaF = new JTextField();

        JLabel cidadeL = new JLabel("Digite sua cidade:");
        JTextField cidadeF = new JTextField();

        JLabel motivoL = new JLabel("Digite o motivo de sua visita:");
        JTextField motivoF = new JTextField();

        c.gridx = 0; c.gridy = 0;
        form.add(nomeL, c);
        c.gridx = 1; c.gridy = 0;
        form.add(nomeF, c);

        c.gridx = 0; c.gridy = 1;
        form.add(cpfL, c);
        c.gridx = 1; c.gridy = 1;
        form.add(cpfF, c);

        c.gridx = 0; c.gridy = 2;
        form.add(nascL, c);
        c.gridx = 1; c.gridy = 2;
        form.add(nascF, c);

        c.gridx = 0; c.gridy = 3;
        form.add(visitaL, c);
        c.gridx = 1; c.gridy = 3;
        form.add(visitaF, c);

        c.gridx = 0; c.gridy = 4;
        form.add(horaL, c);
        c.gridx = 1; c.gridy = 4;
        form.add(horaF, c);

        c.gridx = 0; c.gridy = 5;
        form.add(cidadeL, c);
        c.gridx = 1; c.gridy = 5;
        form.add(cidadeF, c);

        c.gridx = 0; c.gridy = 6;
        form.add(motivoL, c);
        c.gridx = 1; c.gridy = 6;
        form.add(motivoF, c);

        p.add(form, BorderLayout.CENTER);

        JPanel botoes = new JPanel();
        JButton btnSalvar = new JButton("Salvar");
        JButton btnVoltar = new JButton("Voltar");

        botoes.add(btnSalvar);
        botoes.add(btnVoltar);

        p.add(botoes, BorderLayout.SOUTH);

        btnVoltar.addActionListener(e -> cardLayout.show(cards, "home"));

        btnSalvar.addActionListener(e -> {
            String nome = nomeF.getText().trim();
            String cpf = Serializacao.sanitizarCpf(cpfF.getText().trim());
            String dataN = nascF.getText().trim();
            String dataV = visitaF.getText().trim();
            String hora = horaF.getText().trim();
            String cidade = cidadeF.getText().trim();
            String motivo = motivoF.getText().trim();

            if (nome.isBlank() || cpf.isBlank()) {
                JOptionPane.showMessageDialog(this, "Nome e CPF são obrigatórios.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (!Serializacao.apenasDigitos(cpf)) {
                JOptionPane.showMessageDialog(this, "CPF inválido. Digite apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Usuario u = new Usuario(nome, cpf, dataN, dataV, hora, cidade, motivo);
            try {
                List<Usuario> usuarios = Serializacao.carregarUsuarios();
                usuarios.add(u);
                Serializacao.salvarUsuarios(usuarios);
                JOptionPane.showMessageDialog(this, "Usuário salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                nomeF.setText("");
                cpfF.setText("");
                nascF.setText("");
                visitaF.setText("");
                horaF.setText("");
                cidadeF.setText("");
                motivoF.setText("");
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        return p;
    }

    private JPanel criarAnimaisPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Conheça Nossos Animais", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 22));
        p.add(title, BorderLayout.NORTH);

        List<Animal> animais = zoologico.getAnimais();
        JPanel grid = new JPanel(new GridLayout(0, 2, 10, 10));
        grid.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        for (Animal a : animais) {
            JPanel card = new JPanel(new BorderLayout());
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            card.setBackground(Color.WHITE);

            String imgPath = "/images/" + a.getClass().getSimpleName().toLowerCase() + ".png";
            ImageIcon icon = loadIcon(imgPath, 220, 140);
            JLabel pic = new JLabel();

            if (icon != null) {
                pic.setIcon(icon);
            } else {
                pic.setText("[imagem]");
            }

            pic.setHorizontalAlignment(SwingConstants.CENTER);
            card.add(pic, BorderLayout.NORTH);

            JLabel nome = new JLabel(a.getNome() + " - " + a.getClass().getSimpleName(), SwingConstants.CENTER);
            nome.setFont(new Font("SansSerif", Font.BOLD, 16));
            card.add(nome, BorderLayout.CENTER);

            JButton btn = new JButton("Saiba mais");
            btn.addActionListener(e -> showAnimalDetails(a));
            JPanel south = new JPanel();
            south.add(btn);
            JButton voltar = new JButton("Voltar");
            voltar.addActionListener(ev -> cardLayout.show(cards, "home"));
            south.add(voltar);

            card.add(south, BorderLayout.SOUTH);
            grid.add(card);
        }

        JScrollPane scroll = new JScrollPane(grid);
        p.add(scroll, BorderLayout.CENTER);

        return p;
    }

    private ImageIcon loadIcon(String resourcePath, int w, int h) {
        try {
            java.net.URL imgURL = getClass().getResource(resourcePath);

            if (imgURL == null) {
                String fileName = resourcePath.substring(resourcePath.lastIndexOf('/') + 1);
                java.io.File f = new java.io.File("images/" + fileName);
                if (f.exists()) {
                    imgURL = f.toURI().toURL();
                }
            }

            if (imgURL != null) {
                ImageIcon ic = new ImageIcon(imgURL);
                Image img = ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
                return new ImageIcon(img);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

                private void showAnimalDetails(Animal a) {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(a.getNome()).append("\n");
        sb.append("Tipo: ").append(a.getClass().getSimpleName()).append("\n");
        sb.append("Idade: ").append(a.getIdade()).append("\n");
        sb.append("Peso: ").append(a.getPeso()).append(" kg\n");
        sb.append("Cor: ").append(a.getCor()).append("\n");
        sb.append("Habitat: ").append(a.getHabitat()).append("\n");
        sb.append("Altura: ").append(a.getAltura()).append(" m\n");
        sb.append("Locomoção: ").append(a.getLocomocao()).append("\n");
        sb.append("Em extinção: ").append(a.isEmExtincao() ? "Sim" : "Não").append("\n");
        sb.append("Vivo: ").append(a.isVivo() ? "Sim" : "Não").append("\n");

        JOptionPane.showMessageDialog(this, sb.toString(), a.getNome() + " — Ficha", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // tenta usar look and feel do SO
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new AppGUI().setVisible(true);
        });
    }
}