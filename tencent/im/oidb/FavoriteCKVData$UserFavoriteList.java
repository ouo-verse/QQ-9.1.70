package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FavoriteCKVData$UserFavoriteList extends MessageMicro<FavoriteCKVData$UserFavoriteList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 802}, new String[]{"uint64_uin", "uint64_modify_ts", "rpt_msg_favorite_items"}, new Object[]{0L, 0L, null}, FavoriteCKVData$UserFavoriteList.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_modify_ts = PBField.initUInt64(0);
    public final PBRepeatMessageField<FavoriteCKVData$FavoriteItem> rpt_msg_favorite_items = PBField.initRepeatMessage(FavoriteCKVData$FavoriteItem.class);
}
