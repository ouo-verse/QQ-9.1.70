package zi4;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.timi.game.liveroom.impl.room.bottombtn.RedPointIconView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends RecyclerView.ViewHolder {
    private final RedPointIconView E;
    private final TextView F;

    public b(@NonNull View view) {
        super(view);
        this.E = (RedPointIconView) view.findViewById(R.id.t_a);
        this.F = (TextView) view.findViewById(R.id.t_b);
    }
}
