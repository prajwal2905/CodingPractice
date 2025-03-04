class ListNode:
    """Doubly Linked List Node"""
    def __init__(self, username):
        self.username = username
        self.prev = None
        self.next = None


class ShoppingTracker:
    def __init__(self):
        self.user_visits = {}  # Stores visit count for each user
        self.user_nodes = {}   # Stores references to nodes in the doubly linked list
        self.head = ListNode(None)  # Dummy head
        self.tail = ListNode(None)  # Dummy tail
        self.head.next = self.tail  # Connect head to tail
        self.tail.prev = self.head  # Connect tail to head
    
    def _add_to_end(self, node):
        """Adds a node to the end of the linked list (just before tail)"""
        prev_node = self.tail.prev
        prev_node.next = node
        node.prev = prev_node
        node.next = self.tail
        self.tail.prev = node

    def _remove_node(self, node):
        """Removes a node from the doubly linked list"""
        prev_node = node.prev
        next_node = node.next
        prev_node.next = next_node
        next_node.prev = prev_node

    def newUserLogin(self, username):
        if username in self.user_visits:
            self.user_visits[username] += 1
            # If user was in the linked list, remove them
            if username in self.user_nodes:
                self._remove_node(self.user_nodes[username])
                del self.user_nodes[username]  # Remove reference
        else:
            self.user_visits[username] = 1
            new_node = ListNode(username)
            self.user_nodes[username] = new_node
            self._add_to_end(new_node)  # Add to end of linked list

    def getOldestOneTimeVisitingUser(self):
        """Returns the first valid username in the linked list (oldest one-time user)"""
        return self.head.next.username if self.head.next != self.tail else None


# Example Usage:
tracker = ShoppingTracker()
tracker.newUserLogin("john")
tracker.newUserLogin("jeff")
tracker.newUserLogin("jeff")
print(tracker.getOldestOneTimeVisitingUser())  # Output: "john"
tracker.newUserLogin("john")
tracker.newUserLogin("adam")
tracker.newUserLogin("sandy")
print(tracker.getOldestOneTimeVisitingUser())  # Output: "adam"
