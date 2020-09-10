using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DateTimeCalculatorApp.Models
{
    public interface IRepositoryInterface
    {
        void create(History history);
        void update(History history);
        void delete(History history);
        IEnumerable<History> get();
    }
}
