package vn.edu.ntu.dangthikimthuy.fragmentshopping.fragment;

import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    RecyclerView rvListProduct;

    List<Product> listproduct;

    NavController navcontroller;



    FloatingActionButton fabAdd;

    IController controller;

    ProductADapter productAdapter;





    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);



    }



    @Override

    public View onCreateView(

            LayoutInflater inflater, ViewGroup container,

            Bundle savedInstanceState

    ) {

        View view = inflater.inflate(R.layout.fragment_list,container, false);



        fabAdd = view.findViewById(R.id.fabAdd);





        // Inflate the layout for this fragment

        return view;

    }

    //thêm giỏ menu giỏ hàng

    @Override

    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {

        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.mnu_gio_hang, menu);

    }



    @Override

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.mnu_gio_hang)

        {

            CallShoppingFagment();

        }

        return super.onOptionsItemSelected(item);

    }



    private void CallShoppingFagment(){



        navcontroller.navigate(R.id.action_listFragment_to_shoppingFragment);

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);



        //thiếu context nên ép kiêu zô

        navcontroller =  NavHostFragment.findNavController(ListFragment.this);

        ((MainActivity)getActivity()).navcontroller = navcontroller;



        fabAdd.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {

                navcontroller.navigate(R.id.action_listFragment_to_addFragment);

            }

        });



        rvListProduct = view.findViewById(R.id.rvList);

        // controller = (IController) getActivity().getApplication();

        controller = ((MainActivity)getActivity()).controller;

        listproduct = controller.getAllList();

        productAdapter = new ProductADapter(listproduct);

        rvListProduct.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvListProduct.setAdapter(productAdapter);

    }



    private class ProductViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView txtName, txtPrice, txtDesc;

        ImageView imvAddtoCart;

        Product p;

        public ProductViewHolder(@NonNull View itemView) {

            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);

            txtPrice = itemView.findViewById(R.id.txtPrice);

            txtDesc = itemView.findViewById(R.id.txtDesc);

            imvAddtoCart = itemView.findViewById(R.id.imvAddToCart);

            imvAddtoCart.setOnClickListener(this);



        }

        public void bind(Product p ){

            this.p = p;

            txtName.setText(p.getName());

            txtPrice.setText(new Integer(p.getPrice()).toString());

            txtDesc.setText(p.getDesc());

        }



        @Override

        public void onClick(View v) {

            // controller = (IController)getActivity().getApplication();



            if(controller.addToCart(p)){

                Toast.makeText(getActivity(), "Đã thêm " + p.getName() + " vào giỏ hàng",

                        Toast.LENGTH_SHORT).show();

            }

            else{

                Toast.makeText(getActivity(), "Đã có " + p.getName() + " ở trong giỏ hàng",

                        Toast.LENGTH_SHORT).show();

            }



        }

    }



    private  class ProductADapter extends RecyclerView.Adapter<ProductViewHolder> {



        List<Product> listproduct;

        public ProductADapter(List<Product> listproduct) {

            this.listproduct = listproduct;

        }



        @NonNull

        @Override

        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();

            View view = inflater.inflate(R.layout.product, parent, false);

            return new ProductViewHolder(view);

        }



        @Override

        public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

            holder.bind(listproduct.get(position));

        }



        @Override

        public int getItemCount() {

            return listproduct.size();

        }





    }
}
