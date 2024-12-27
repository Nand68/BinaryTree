class Solution {
    public static int minTime(Node root, int target) {
        // Step 1: Create a map to store parent pointers
        HashMap<Node, Node> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        // Step 2: Find the target node
        Node targetNode = findTargetNode(root, target);
        if (targetNode == null) {
            return -1; // Target not found
        }

        // Step 3: Perform BFS to calculate the minimum time
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(targetNode);
        visited.add(targetNode);

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean spread = false; // Flag to check if any fire spread at this level

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();

                // Check left child
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                    spread = true;
                }

                // Check right child
                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                    spread = true;
                }

                // Check parent node
                if (parentMap.containsKey(current) && !visited.contains(parentMap.get(current))) {
                    queue.add(parentMap.get(current));
                    visited.add(parentMap.get(current));
                    spread = true;
                }
            }

            // If fire spread at this level, increase time
            if (spread) {
                time++;
            }
        }

        return time;
    }

    // Helper function to build the parent map
    private static void buildParentMap(Node root, HashMap<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // If current has a left child, add it to the map and queue
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }

            // If current has a right child, add it to the map and queue
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }
    }

    // Helper function to find the target node
    private static Node findTargetNode(Node root, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.data == target) {
                return current; // Found target node
            }

            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return null; // Target node not found
    }
}
