package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZIntimateSpaceAlbum$GetAllAlbumListByUserReq extends MessageMicro<QZIntimateSpaceAlbum$GetAllAlbumListByUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uin"}, new Object[]{0L}, QZIntimateSpaceAlbum$GetAllAlbumListByUserReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
}
