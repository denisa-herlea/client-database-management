package controllers;

import views.ClientView;
import views.MainView;
import views.ProductOrderView;
import views.ProductView;



public class MainController {

    private MainView mainView;
    public MainController(MainView mainView){
        this.mainView=mainView;


        this.mainView.addClientOperationListener(e->{
            ClientView clientView=new ClientView();
            ClientController clientController=new ClientController(clientView);

        });

        this.mainView.addProductOperationListener(e->{
            ProductView productView=new ProductView();
            ProductController productController=new ProductController(productView);

        });

        this.mainView.addProductOrdersListener(e->{
            ProductOrderView productOrderView=new ProductOrderView();
            ProductOrderController productOrderControllerr=new ProductOrderController(productOrderView);

        });

    }

}
