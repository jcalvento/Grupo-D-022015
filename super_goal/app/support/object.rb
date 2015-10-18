class Object

  def subclass_responsibility
    fail "#{object_defining_method} had the responsibility to implement :#{self.calling_message_name} #{message_side} method"
  end

  def message_side
    is_class? ? 'class' : 'instance'
  end

  def object_defining_method
    is_class? ? self : self.class
  end

  protected

  def is_class?
    self.instance_of? Class
  end

  def calling_message_name
    message_reference_with_path_and_line_number = caller[1]
    message_name = message_reference_with_path_and_line_number[/`([^']*)'/, 1]

    message_name.to_sym
  end

end