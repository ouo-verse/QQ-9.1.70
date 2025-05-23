package xg4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.emosearch.EmotionSearchItem;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmotionPanelData;
import com.tencent.mobileqq.emoticonview.IFavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xg4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\b\u0003\t\nB\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lxg4/e;", "", "Lxg4/b;", "b", "Lxg4/b;", "mDataHelper", "<init>", "()V", "a", "c", "d", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f447976a = new e();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final xg4.b mDataHelper = new xg4.b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0006H$R&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\t8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lxg4/e$a;", "T", "", "Landroidx/lifecycle/LiveData;", "", "b", "", "d", "f", "Landroidx/lifecycle/MutableLiveData;", "a", "Landroidx/lifecycle/MutableLiveData;", "c", "()Landroidx/lifecycle/MutableLiveData;", "mData", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static abstract class a<T> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final MutableLiveData<List<T>> mData = new MutableLiveData<>();

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(a this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.f();
        }

        @NotNull
        public final LiveData<List<T>> b() {
            return this.mData;
        }

        @NotNull
        protected final MutableLiveData<List<T>> c() {
            return this.mData;
        }

        public final void d() {
            ThreadManagerV2.excute(new Runnable() { // from class: xg4.d
                @Override // java.lang.Runnable
                public final void run() {
                    e.a.e(e.a.this);
                }
            }, 32, null, true);
        }

        protected abstract void f();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001\u0007\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0006\u0010\u0005\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003R\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lxg4/e$b;", "Lxg4/e$a;", "Lcom/tencent/mobileqq/emoticonview/EmoticonInfo;", "", "f", "i", "k", "xg4/e$b$a", "c", "Lxg4/e$b$a;", "syncListener", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends a<EmoticonInfo> {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final b f447979b = new b();

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final a syncListener = new a();

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\"\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016\u00a8\u0006\r"}, d2 = {"xg4/e$b$a", "Lcom/tencent/mobileqq/emosm/favroaming/n;", "Lcom/tencent/mobileqq/data/CustomEmotionData;", "", "downloadedCount", "", "onDownloadFinish", "onUploadFinish", "onSyncFinish", "data", FavEmoConstant.ROAMING_TYPE_PANEL, "hasDownloaded", "onFileDone", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes26.dex */
        public static final class a extends com.tencent.mobileqq.emosm.favroaming.n<CustomEmotionData> {
            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void b() {
                b.f447979b.f();
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.n
            public void onDownloadFinish(int downloadedCount) {
                com.tencent.timi.game.utils.l.i("Favorite_", "onDownloadFinish downloadedCount:" + downloadedCount);
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.n
            public void onSyncFinish() {
                com.tencent.timi.game.utils.l.i("Favorite_", "onSyncFinish ");
                ThreadManagerV2.excute(new Runnable() { // from class: xg4.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.b.a.b();
                    }
                }, 32, null, true);
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.n
            public void onUploadFinish() {
                com.tencent.timi.game.utils.l.i("Favorite_", "onUploadFinish ");
            }

            @Override // com.tencent.mobileqq.emosm.favroaming.n
            public void onFileDone(@Nullable CustomEmotionData data, int needDownload, int hasDownloaded) {
                com.tencent.timi.game.utils.l.i("Favorite_", "onFileDone data:" + data + ", needDownload:" + needDownload + ", hasDownloaded:" + hasDownloaded);
            }
        }

        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(AppRuntime appRuntime, IFavroamingManagerService service) {
            Intrinsics.checkNotNullParameter(service, "$service");
            IRuntimeService runtimeService = appRuntime.getRuntimeService(IFavroamingDBManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026nt.MAIN\n                )");
            List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel = ((IFavroamingDBManagerService) runtimeService).syncGetCustomEmotionInfoShowedInPanel();
            com.tencent.timi.game.utils.l.h("Favorite_", 1, "favDataInit dataList size " + syncGetCustomEmotionInfoShowedInPanel.size());
            if (syncGetCustomEmotionInfoShowedInPanel.size() == 0) {
                service.syncLocalDel();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void l(ArrayList finalData) {
            Intrinsics.checkNotNullParameter(finalData, "$finalData");
            f447979b.c().setValue(finalData);
        }

        @Override // xg4.e.a
        protected void f() {
            boolean z16;
            boolean z17;
            com.tencent.timi.game.utils.l.i("Favorite_", "refreshInner ");
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFavroamingDBManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026nstant.MAIN\n            )");
            List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel = ((IFavroamingDBManagerService) runtimeService).syncGetCustomEmotionInfoShowedInPanel();
            final ArrayList arrayList = new ArrayList();
            for (EmoticonInfo emoticonInfo : syncGetCustomEmotionInfoShowedInPanel) {
                boolean z18 = false;
                if (emoticonInfo instanceof IFavoriteEmoticonInfo) {
                    String url = ((IFavoriteEmoticonInfo) emoticonInfo).getUrl();
                    if (url != null && url.length() != 0) {
                        z17 = false;
                    } else {
                        z17 = true;
                    }
                    if (!z17) {
                        arrayList.add(emoticonInfo);
                    }
                }
                if (emoticonInfo instanceof IPicEmoticonInfo) {
                    IPicEmoticonInfo iPicEmoticonInfo = (IPicEmoticonInfo) emoticonInfo;
                    if (iPicEmoticonInfo.getEmoticon() != null) {
                        String str = iPicEmoticonInfo.getEmoticon().epId;
                        if (str != null && str.length() != 0) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (!z16) {
                            String str2 = iPicEmoticonInfo.getEmoticon().eId;
                            if (str2 == null || str2.length() == 0) {
                                z18 = true;
                            }
                            if (!z18) {
                                com.tencent.timi.game.utils.l.i("Favorite_", "refreshInner " + emoticonInfo + " is IPicEmoticonInfo:" + iPicEmoticonInfo.getEmoticon().epId + ", " + iPicEmoticonInfo.getEmoticon().eId);
                                arrayList.add(emoticonInfo);
                            }
                        }
                    }
                }
                com.tencent.timi.game.utils.l.i("Favorite_", "refreshInner " + emoticonInfo + " is not IFavoriteEmoticonInfo or url is null");
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xg4.g
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.l(arrayList);
                }
            });
        }

        public final void i() {
            com.tencent.timi.game.utils.l.i("Favorite_", "favDataInit ");
            final AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            IRuntimeService runtimeService = waitAppRuntime.getRuntimeService(IFavroamingManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026nstant.MAIN\n            )");
            final IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) runtimeService;
            iFavroamingManagerService.addSyncListener(syncListener);
            ThreadManagerV2.excute(new Runnable() { // from class: xg4.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.b.j(AppRuntime.this, iFavroamingManagerService);
                }
            }, 32, null, true);
        }

        public final void k() {
            com.tencent.timi.game.utils.l.i("Favorite_", "favSyncRoaming ");
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFavroamingManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026nstant.MAIN\n            )");
            IFavroamingManagerService iFavroamingManagerService = (IFavroamingManagerService) runtimeService;
            iFavroamingManagerService.addSyncListener(syncListener);
            iFavroamingManagerService.syncLocalDel();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0003H\u0014\u00a8\u0006\u0007"}, d2 = {"Lxg4/e$d;", "Lxg4/e$a;", "Lcom/tencent/mobileqq/emoticonview/SystemAndEmojiEmoticonInfo;", "", "f", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends a<SystemAndEmojiEmoticonInfo> {

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final d f447986b = new d();

        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void h(ArrayList finalData) {
            Intrinsics.checkNotNullParameter(finalData, "$finalData");
            f447986b.c().setValue(finalData);
        }

        @Override // xg4.e.a
        protected void f() {
            List<EmotionPanelData> a16 = e.mDataHelper.a();
            final ArrayList arrayList = new ArrayList();
            for (EmotionPanelData emotionPanelData : a16) {
                if (emotionPanelData instanceof SystemAndEmojiEmoticonInfo) {
                    arrayList.add(emotionPanelData);
                }
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: xg4.j
                @Override // java.lang.Runnable
                public final void run() {
                    e.d.h(arrayList);
                }
            });
        }
    }

    e() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\b\u001a\u00020\u0003J\b\u0010\t\u001a\u00020\u0003H\u0014R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lxg4/e$c;", "Lxg4/e$a;", "Lcom/tencent/mobileqq/emosm/emosearch/EmotionSearchItem;", "", "j", "", "keyword", "k", tl.h.F, "f", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService;", "c", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService;", "searchService", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchTask;", "d", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchTask;", "hotPicTask", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchResult;", "e", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$EmotionSearchResult;", "mCurrentResult", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$a;", "Lcom/tencent/mobileqq/emosm/api/IEmotionSearchManagerService$a;", "mCallback", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends a<EmotionSearchItem> {

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final IEmotionSearchManagerService searchService;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private static IEmotionSearchManagerService.EmotionSearchResult mCurrentResult;

        /* renamed from: b, reason: collision with root package name */
        @NotNull
        public static final c f447981b = new c();

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final IEmotionSearchManagerService.EmotionSearchTask hotPicTask = new IEmotionSearchManagerService.EmotionSearchTask(0);

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private static final IEmotionSearchManagerService.a mCallback = new IEmotionSearchManagerService.a() { // from class: xg4.i
            @Override // com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService.a
            public final void onSearchCallBack(IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
                e.c.i(emotionSearchResult);
            }
        };

        static {
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IEmotionSearchManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026nstant.MAIN\n            )");
            searchService = (IEmotionSearchManagerService) runtimeService;
        }

        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void i(IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult) {
            Integer num;
            int i3 = emotionSearchResult.nResult;
            ArrayList<EmotionSearchItem> arrayList = emotionSearchResult.itemList;
            if (arrayList != null) {
                num = Integer.valueOf(arrayList.size());
            } else {
                num = null;
            }
            com.tencent.timi.game.utils.l.i("SearchAndHotPic", "onSearchResult r=" + i3 + ", size:" + num);
            ArrayList arrayList2 = new ArrayList();
            ArrayList<EmotionSearchItem> arrayList3 = emotionSearchResult.itemList;
            if (arrayList3 != null) {
                arrayList2.addAll(arrayList3);
            }
            mCurrentResult = emotionSearchResult;
            f447981b.c().postValue(arrayList2);
        }

        public final void h() {
            IEmotionSearchManagerService iEmotionSearchManagerService = searchService;
            iEmotionSearchManagerService.setSearchCallBack(mCallback);
            IEmotionSearchManagerService.EmotionSearchResult emotionSearchResult = mCurrentResult;
            if (emotionSearchResult != null && !emotionSearchResult.isHasMore()) {
                com.tencent.timi.game.utils.l.e("SearchAndHotPic", "loadMore give up no more!");
            } else {
                iEmotionSearchManagerService.loadMore();
            }
        }

        public final void j() {
            IEmotionSearchManagerService iEmotionSearchManagerService = searchService;
            iEmotionSearchManagerService.resetData();
            iEmotionSearchManagerService.setSearchCallBack(mCallback);
            iEmotionSearchManagerService.pushEmotionSearchTask(hotPicTask);
        }

        public final void k(@NotNull String keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            IEmotionSearchManagerService iEmotionSearchManagerService = searchService;
            iEmotionSearchManagerService.setSearchCallBack(mCallback);
            com.tencent.timi.game.utils.l.h("SearchAndHotPic", 1, "searchKeyword " + keyword);
            iEmotionSearchManagerService.pushEmotionSearchTask(new IEmotionSearchManagerService.EmotionSearchTask(1, keyword));
        }

        @Override // xg4.e.a
        protected void f() {
        }
    }
}
