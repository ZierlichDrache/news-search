import { LayoutService, Layout } from './layout.service';

describe('LayoutService', () => {
  let service: LayoutService;

  beforeEach(() => {
    service = new LayoutService();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should screenLayout be Laptop when screenWidth is over 1200', () => {

    // when
    service.onResize({target: {innerWidth: 1201}});

    // then
    expect(service.screenLayout).toBe(Layout.Laptop);
  });

  it('should screenLayout be Tablet when screenWidth is between 769 and 1200', () => {
    
    // when
    service.onResize({target: {innerWidth: 769}});

    // then
    expect(service.screenLayout).toBe(Layout.Tablet);
  });

  it('should screenLayout be Tablet when screenWidth is below 769', () => {
    
    // when
    service.onResize({target: {innerWidth: 768}});

    // then
    expect(service.screenLayout).toBe(Layout.Mobile);
  });  
});
