using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DateTimeCalculatorApp.Models
{
    public class History
    {
        public int Id { get; set; }
        public string Date { get; set; }
        public string OperationSelected { get; set; }
        public string Result { get; set; }
        public string Operand { get; set; }



    }
}
