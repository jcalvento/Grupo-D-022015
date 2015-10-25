class PositionValidator < ActiveModel::Validator
  def validate(record)
    valid_positions = %w(Forward forward Midfield midfield Defender defender GoalKeeper goalkeeper)
    value = record[options[:field]]

    unless valid_positions.include? value
      record.errors[:base] << "#{value} is not a valid position"
    end
  end
end