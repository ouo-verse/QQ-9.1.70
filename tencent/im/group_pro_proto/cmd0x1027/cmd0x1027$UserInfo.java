package tencent.im.group_pro_proto.cmd0x1027;

import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x1027$UserInfo extends MessageMicro<cmd0x1027$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{INetChannelCallback.KEY_TINY_ID, IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "head_url"}, new Object[]{0L, "", ""}, cmd0x1027$UserInfo.class);
    public final PBUInt64Field tiny_id = PBField.initUInt64(0);
    public final PBStringField nick_name = PBField.initString("");
    public final PBStringField head_url = PBField.initString("");
}
