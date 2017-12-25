package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sarabjeetsingh.koinexticker.R;

import model.Crypto;

/**
 * Created by Sarabjeet Singh on 26-12-2017.
 */

public class CryptoListAdapter extends RecyclerView.Adapter<CryptoListAdapter.ViewHolder> {

    Crypto crypto;
    String name;
    String symbol;
    String value;
    Context mContext;

    public CryptoListAdapter(Crypto crypto, Context context) {
        this.crypto = crypto;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.cryptoitem, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        switch (position) {
            case 0:
                name = "Bitcoin";
                symbol = "BTC";
                value = crypto.getBitcoin();
                break;
            case 1:
                name = "Etherium";
                symbol = "ETH";
                value = crypto.getEther();
                break;
            case 2:
                name = "Bitcoin Cash";
                symbol = "BCH";
                value = crypto.getBitcoinCash();
                break;
            case 3:
                name = "Ripple";
                symbol = "XRP";
                value = crypto.getRipple();
                break;
            case 4:
                name = "Lite Coin";
                symbol = "LTC";
                value = crypto.getLitecoin();
                break;
            default:
                Log.i("Error", "List count mismatch");
        }

        holder.name.setText(name);
        holder.symbol.setText(symbol);
        holder.price.setText(value);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView symbol;
        TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.nameText);
            this.symbol = itemView.findViewById(R.id.symbolText);
            this.price = itemView.findViewById(R.id.priceText);
        }
    }

}
