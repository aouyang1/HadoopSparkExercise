import json
import os

def flatten_json(input_file, output_file=None):
    """Flattens a JSON file such that each row contains a single record.

    Reads in a JSON file and flattens each JSON record into a single line.
    Successive records are appended to the file. Function does not check
    if JSON file is a valid input.

    Args:
        input_file: Full file path of the JSON file to flatten
        output_file: (optional) JSON file to write to. If none given
            the output name will be the same file name appended with 
            "_flat".

    Returns:
        Nothing
    """

    if output_file is None:
        file_components = os.path.splitext(input_file)
        output_file = "{}{}{}".format(file_components[0],
                                      "_flat",
                                      file_components[1])

    json_data = open(input_file).read()
    data = json.loads(json_data)

    with open(output_file, 'w') as outfile:
        for record_num, record in enumerate(data):
            json.dump(record, outfile)
            outfile.write('\n')
    
    print "Number of records: {}".format(record_num+1)
