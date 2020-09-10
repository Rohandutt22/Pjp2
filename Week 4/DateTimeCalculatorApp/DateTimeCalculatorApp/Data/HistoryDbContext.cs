using DateTimeCalculatorApp.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DateTimeCalculatorApp.Data
{
    public class HistoryDbContext:DbContext
    {
        public DbSet<History> histories { get; set; }

        public HistoryDbContext(DbContextOptions<HistoryDbContext>options):base(options)
        {

        }
       

    }
}
