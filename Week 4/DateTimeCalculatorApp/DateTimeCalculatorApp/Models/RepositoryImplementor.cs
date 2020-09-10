using DateTimeCalculatorApp.Data;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DateTimeCalculatorApp.Models
{
    public class RepositoryImplementor : IRepositoryInterface
    {
        public HistoryDbContext historyDbContext;

        public RepositoryImplementor(HistoryDbContext h)
        {
            this.historyDbContext = h;
        }
        void IRepositoryInterface.create(History history)
        {
            historyDbContext.histories.Add(history);
            historyDbContext.SaveChanges(true);
        }

        void IRepositoryInterface.delete(History history)
        {
            throw new NotImplementedException();
        }

      IEnumerable<History> IRepositoryInterface.get()
        {
           return  historyDbContext.histories;
        }

        void IRepositoryInterface.update(History history)
        {
            throw new NotImplementedException();
        }
    }
}
