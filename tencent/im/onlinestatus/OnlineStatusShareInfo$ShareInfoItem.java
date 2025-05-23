package tencent.im.onlinestatus;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.mini.servlet.GetGuildJoinUrlServlet;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusShareInfo$ShareInfoItem extends MessageMicro<OnlineStatusShareInfo$ShareInfoItem> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field share_time;
    public final PBBytesField share_url;
    public final PBBytesField share_wording;
    public OnlineStatusShareInfo$StatusDesc status_desc;
    public final PBBytesField trans_info;
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt32Field share_type = PBField.initUInt32(0);

    static {
        String[] strArr = {"uin", AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, GetGuildJoinUrlServlet.BUNDLE_KEY_URL, "share_wording", "trans_info", QCircleSchemeAttr.CollectBoxDetail.SHARE_TIME, "status_desc"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 58}, strArr, new Object[]{0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0L, null}, OnlineStatusShareInfo$ShareInfoItem.class);
    }

    public OnlineStatusShareInfo$ShareInfoItem() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.share_url = PBField.initBytes(byteStringMicro);
        this.share_wording = PBField.initBytes(byteStringMicro);
        this.trans_info = PBField.initBytes(byteStringMicro);
        this.share_time = PBField.initUInt64(0L);
        this.status_desc = new OnlineStatusShareInfo$StatusDesc();
    }
}
