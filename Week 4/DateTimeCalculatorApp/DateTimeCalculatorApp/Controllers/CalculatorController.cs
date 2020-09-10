using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

using System.Diagnostics;

using Microsoft.Extensions.Logging;
using DateTimeCalculatorApp.Models;
using DateTimeCalculatorApp.Data;

namespace DateTimeCalculatorApp.Controllers
{
    public class CalculatorController:Controller
    {
        public IRepositoryInterface repositoryInterface;

        public CalculatorController(IRepositoryInterface repositoryInterface)
        {
            this.repositoryInterface = repositoryInterface;
        }


        //public CalculatorController(IRepositoryInterface h)

        public IActionResult index()
        {
           
            return View();
        }

        
        public IActionResult add(string input_date, string select_type,string no_of_units)
        {
            if (input_date!=null)
            {
                History h = new History();
                h.Date = input_date;

                DateTime dateTime = DateTime.Parse(input_date);
                switch (select_type)
                {
                    case "Day":
                        dateTime = dateTime.AddDays(int.Parse(no_of_units));
                        break;
                    case "Year":
                        dateTime = dateTime.AddYears(int.Parse(no_of_units));
                        break;
                    case "Month":
                        dateTime = dateTime.AddMonths(int.Parse(no_of_units));
                        break;

                }
                h.Result = dateTime.ToString();
                h.Operand = select_type + ":" + no_of_units;
                h.OperationSelected = "add";
                repositoryInterface.create(h);
                ViewBag.result = h.Result;
            }
            return View();
        }

        public IActionResult sub(string input_date, string select_type, string no_of_units)
        {
            if (input_date != null)
            {
                History h = new History();
                h.Date = input_date;

                DateTime dateTime = DateTime.Parse(input_date);
                switch (select_type)
                {
                    case "Day":
                        dateTime = dateTime.AddDays(-1*int.Parse(no_of_units));
                        break;
                    case "Year":
                        dateTime = dateTime.AddYears(-1*int.Parse(no_of_units));
                        break;
                    case "Month":
                        dateTime = dateTime.AddMonths(-1*int.Parse(no_of_units));
                        break;

                }
                h.Result = dateTime.ToString();
                h.Operand = select_type + ":" + no_of_units;
                h.OperationSelected = "sub";
                repositoryInterface.create(h);
                ViewBag.result = h.Result;
            }
            return View();
        }


        public IActionResult dayDetail(string input_date)
        {
            if (input_date != null)
            {
                History h = new History();
                h.Date = input_date;

                DateTime dateTime = DateTime.Parse(input_date);
                
                h.Result = dateTime.DayOfWeek.ToString()+" "+dateTime.ToString();
                h.Operand = "no operands";
                h.OperationSelected = "getDetail";
                repositoryInterface.create(h);
                ViewBag.result = h.Result;
            }
            return View();
        }


        public IActionResult getPrevious()
        {

            return View(repositoryInterface.get());
        }

    }
}
